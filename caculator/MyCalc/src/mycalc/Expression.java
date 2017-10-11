package mycalc;
import java.util.*;
import java.util.regex.*;
public class Expression {
	char[][] Prior = {// +   -    *   /   (   )  #   ^   sin  cos 
						{'>','>','<','<','<','>','>','<','<','<','<','<','<','<','<','<'},//+
						{'>','>','<','<','<','>','>','<','<','<','<','<','<','<','<','<'},//-
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},//*
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},//
						{'<','<','<','<','<','=',' ','<','<','<','<','<','<','<','<','<'},//(
						{'>','>','>','>',' ','>','>','>','>','>','>','>','>','>','>','>'},//)
						{'<','<','<','<','<',' ','=','<','<','<','<','<','<','<','<','<'},//#
						{'>','>','>','>','<','>','>',' ','>','>','>','>','>','>','>','>'},//^
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},//sin
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},//cos
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},//tan
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},//
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},
						{'>','>','>','>','<','>','>','<','>','>','>','>','>','>','>','>'},
	};
	double Operate1(double a,String theta,double b) {
		double result = 0;
		if(theta.equals("+")) {
			result = a+b;
		}else if(theta.equals("-")) {
			result = a-b;
		}else if(theta.equals("*")) {
			result = a*b;
		}else if(theta.equals("/")) {
			result = a/b;
		}else if(theta.equals("^")) {
			result = Math.pow(a, b);
		}
		return result;
	}
	double Operate2(double b,String theta){
		double result = 0;
		if(theta.equals("sin")){
			result = Math.sin(b);
		}else if(theta.equals("cos")){
			result = Math.cos(b);
		}else if(theta.equals("tan")){
			result = Math.tan(b);
		}else if(theta.equals("log")){
			result = Math.log(b);
		}else if(theta.equals("arcsin")){
			result = Math.asin(b);
		}else if(theta.equals("arccos")){
			result = Math.acos(b);
		}else if(theta.equals("arctan")){
			result = Math.atan(b);
		}else if(theta.equals("sqrt")){
			result = Math.sqrt(b);
		}
		return result;
	}
	String[] OPSET = {"+","-","*","/","(",")","#","^","sin","cos","tan","log","arcsin","arccos","arctan","sqrt"};
	char[] OPOP = {'+','-','*','/','(',')','#','^'};
	boolean IsNumber(char c) {
		boolean flag =false;
		if(c>='0'&&c<='9'||c=='.')
			flag = true;
		return flag;
	}
	boolean In(char theta,char[] TestOp) {
		boolean flag = false;
		for(int i=0;i<TestOp.length;i++) {
			if(theta == TestOp[i]) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	char precede(String Aop,String Bop) {
		int i,j;
		for(i=0;i<OPSET.length;i++) {
			if(Aop.equals(OPSET[i]))
				break;
		}
		for(j=0;j<OPSET.length;j++) {
			if(Bop.equals(OPSET[j]))
				break;
		}
		return Prior[i][j];
		
		
	}
	
	public double ToExpression(String MyExp) {
		Stack<String> OPTR = new Stack<String>();
		Stack<Double> OPND = new Stack<Double>();
		String TempData = "";
		double Data,a,b = 0,r;
		char c;
		String theta = "";
		MyExp = MyExp + "#";
		MyExp=MyExp.replaceAll(" ", "");
		String s = "[a-z]+";
        Pattern pattern = Pattern.compile(s);  
        Matcher m = pattern.matcher(MyExp); 
		char[] ME = MyExp.toCharArray();
		int i=0;
		
		OPTR.push("#");
		c = ME[0];
		
		while(c!='#'||OPTR.peek()!="#") {
			if(IsNumber(c)) {
				TempData = TempData + c;
				c = ME[++i];
				if(!IsNumber(c)) {
					Data = Double.valueOf(TempData);
					OPND.push(Data);
					TempData = "";
				}
			}
			else if(!IsNumber(c)){
				if(In(c,OPOP)) {
					theta = "";
					theta = theta + c;
				}
				else if(m.find()){
					theta = m.group();
					i = i+m.group().length()-1;
				}
				switch(precede(OPTR.peek(),theta)) {
				case '<':
					OPTR.push(theta);
					c = ME[++i];
					break;
				case '=':
					OPTR.pop();
					c = ME[++i];
					break;
				case '>':
					theta = OPTR.peek();
					OPTR.pop();
					if(theta.length()==1){
						b = OPND.peek();
						OPND.pop();
						a = OPND.peek();
						OPND.pop();
						OPND.push(Operate1(a,theta,b));
					}
					else{
						b = OPND.peek();
						OPND.pop();
						OPND.push(Operate2(b,theta));
					}
				}
			}
		}
		r = OPND.peek();
		return r;
	}
}