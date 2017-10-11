package mycalc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCalc {
	static Scanner scan = new Scanner(System.in);
	static String exp;
	public static void main(String [] args) {
		
		Expression E = new Expression();
		double result;
		int flag=0;
		String read2 = "";
		char[] data;
		while(true){
			exp = scan.nextLine();
			data = exp.toCharArray();
			for(int i=0;i<data.length;i++){
				if(data[i]== 'x'||data[i]=='y'||data[i]=='z'){
					System.out.println("please input the value of it(them): ");
					read2 = new Scanner(System.in).nextLine();
					flag = 1;
					break;
				}
			}
			if(flag==1){
				String x_value = "";
				String y_value = "";
				String z_value = "";
				String str = "\\d+(\\.\\d+)?";
				Pattern p = Pattern.compile(str);  
				Matcher m = p.matcher(read2);  
				int x = read2.indexOf('x');
				if(x!=-1){
					if(m.find()){
						x_value = m.group();
						exp = exp.replace("x", x_value);
					}
				}
				int y = read2.indexOf('y');
				if(y!=-1){
					if(m.find()){
						y_value = m.group();
						exp = exp.replace("y", y_value);
					}
				}
				int z = read2.indexOf('z');
				if(z!=-1){
					if(m.find()){
						z_value = m.group();
						exp = exp.replace("z", z_value);
					}
				}
			}
			result = E.ToExpression(exp);
			System.out.println(result);
		}
	}
}
