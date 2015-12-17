package hxk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @description
 *2015-4-8  下午9:01:06
 */
public class Student {
    private String name;
    private int age;
    private List<Integer> socres = new ArrayList<Integer>();
    
    public Student() {}
    
    public Student(String name, int age, List<Integer> socres) {
	super();
	this.name = name;
	this.age = age;
	this.socres = socres;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public List<Integer> getSocres() {
        return socres;
    }
    public void setSocres(List<Integer> socres) {
        this.socres = socres;
    }

    @Override
    public String toString() {
	return "Student [name=" + name + ", age=" + age + ", socres=" + socres+ "]";
    }
    
    
}
