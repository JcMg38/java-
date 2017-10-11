package cn.edu.szu;
/*
 * 编写一个Student类，类中包含三个成员变量name，sex和stuid。定义对应的方法对这三个变量进行修改和读取。
 * */
public class Student {
	private String name = "";
	private String sex = "";
	private String stuid = "";
	public void setter_name(String name) {
		this.name = name;
	}
	public String getter_name() {
		return name;
	}
	public void setter_sex(String sex) {
		this.sex = sex;
	}
	public String getter_sex() {
		return sex;
	}
	public void setter_stuid(String stuid) {
		this.stuid = stuid;
	}
	public String getter_stuid() {
		return stuid;
	}
}