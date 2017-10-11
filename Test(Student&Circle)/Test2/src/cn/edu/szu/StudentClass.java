package cn.edu.szu;

import java.util.*;

/*
 * 编写一个StudentClass类，该类可以存储不限数目的Student对象（可以是0个，也可以是多个），
 * System.out.println(sc)可以打印出所有学生的名字(sc是StudentClass类型的对象)。
 * */
public class StudentClass {
	String names = "";
	static int i = 0;
	LinkedList<Student> list = new LinkedList<Student>(); 
	public void add_student(Student s) {
		list.add(s);
		i++;
		names = names + "name" + i + ": " + s.getter_name() + "\n";
	}
	
	public String toString() {
		if(names.equals(""))
			names =  "There are no students!";
		return names;
	}
}
