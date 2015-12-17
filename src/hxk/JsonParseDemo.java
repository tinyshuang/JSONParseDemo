package hxk;

import hxk.model.Student;

import java.util.Arrays;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




/**
 * @author Administrator json分解
 * @description
 *2015-3-25  下午10:00:27
 */
public class JsonParseDemo {
    
    public static void main(String[] args) {
	createJson();
    }
    
    
    /**
     * @description 解析json,并获取其中的值
     *2015-12-17  下午8:57:07
     *返回类型:void
     */
    public static void parseString(){
	String jsons = "{'code':200,'description':'','results':[{'DLBM':'011','DLMC':'水田','MJ':11613.26},{'DLBM':'031','DLMC':'有林地','MJ':336.36},{'DLBM':'203','DLMC':'村庄','MJ':3332.34},{'DLBM':'031','DLMC':'有林地','MJ':1401.93},{'DLBM':'013','DLMC':'旱地','MJ':241.98},{'DLBM':'114','DLMC':'坑塘水面','MJ':5685.77}],'state':'true'}";
	JSONObject object = JSONObject.fromObject(jsons);
	JSONArray array = object.getJSONArray("results");
	double sum = 0;
	for (int i = 0; i < array.size(); i++) {
	    JSONObject json = array.getJSONObject(i);
	    if(json.getString("DLBM").startsWith("01")){
		sum += json.getDouble("MJ");
	    }
	}
	System.out.println(sum);
    }
    
    /**
     * @description 获取json里面的数组	
     *2015-12-17  下午8:57:45
     *返回类型:void
     */
    public static void parseArray(){
	String jsons = "{'results':[['ferfs','03.jpg'],['serfgse','04.jgp'],['ferfwae','05.jpg'],['asad','01.jpg'],['fasef','02.jpg']],'code':200,'state':'success'}";
	JSONObject object = JSONObject.fromObject(jsons);
	JSONArray array = object.getJSONArray("results");
	for (Object object2 : array) {
	    JSONArray jsonObject = JSONArray.fromObject(object2);
	    Object[] answer = jsonObject.toArray();
	    System.out.println("--------");
	    System.out.println(answer[0]);
	    System.out.println(answer[1]);
	}
	
	
    }
    
    /**
     * @description 对象与json的相互转换	
     *2015-12-17  下午8:59:37
     *返回类型:void
     */
    public static void parseObject(){
	Integer[] scores = {70,80,90};
	Student student = new Student("hxk", 20, Arrays.asList(scores));
	JSONObject object = JSONObject.fromObject(student);
	for(Object key : object.keySet()){
	    System.out.println("key : " + key + " ---> value : " + object.get(key));
	}
	
	//根据json对象转换成对象...
	Student stu = (Student) JSONObject.toBean(object,Student.class);
	System.out.println(stu);
	
	//根据字符串转换
	String json = "{name:'tinys',age:15}";
	JSONObject obj = JSONObject.fromObject(json);
	stu = (Student) JSONObject.toBean(obj, Student.class);
	System.out.println(stu);
    }
    
    
    /**
     * @description 创建一个json	
     *2015-12-17  下午9:00:11
     *返回类型:void
     */
    public static void createJson(){
	JSONObject json = new JSONObject();
	json.put("time", "2014-05-07");
	json.put("age", 15);
	json.put("flag", true);
	System.out.println(json);
    }
    
}
