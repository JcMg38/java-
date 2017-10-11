package test;
import cn.edu.szu.*;
import java.util.*;
public class TestStudentClass {
	private static Scanner scan;

	public static void main(String [] args) {
		StudentClass sc = new StudentClass();
		Student s = new Student();
		scan = new Scanner(System.in);
		String name = "";
		String sex = "";
		String stuid = "";
		System.out.println("Input Stop to stop inputting!");
		
		while(true) {
		System.out.println("The name is: ");
		name = scan.nextLine();
		if(name.equals("Stop")){
			break;
		}
		System.out.println("The sex is: ");
		sex = scan.nextLine();
		System.out.println("The student's id is: ");
		stuid = scan.nextLine();
		
		s.setter_name(name);
		s.setter_sex(sex);
		s.setter_stuid(stuid);

		sc.add_student(s);
		}
		System.out.println(sc);
	}
}
