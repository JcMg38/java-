package cn.edu.szu;
/*
 * ��дһ��Student�࣬���а���������Ա����name��sex��stuid�������Ӧ�ķ��������������������޸ĺͶ�ȡ��
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