package cn.edu.szu;

import java.util.*;

/*
 * ��дһ��StudentClass�࣬������Դ洢������Ŀ��Student���󣨿�����0����Ҳ�����Ƕ������
 * System.out.println(sc)���Դ�ӡ������ѧ��������(sc��StudentClass���͵Ķ���)��
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
