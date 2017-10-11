package test5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
1.	定义类Shape，类内有周长和面积属性；
2.	定义接口ShapeArea，接口内有方法计算面积；
3.	定义子类Triangle和Circle，这两个子类除了继承Shape，还需要实现接口ShapeArea；
4.	子类Triangle和Circle要有计算周长的方法。
5.	Circle类中定义方法，可以根据输入的面积计算圆的半径。
6.	在main方法中测试上述功能。
*/
class Shape {/*定义类Shape，类内有周长和面积属性；*/
	protected double round;
	protected double area;
}

interface ShapeArea {/*定义接口ShapeArea，接口内有方法计算面积；*/
	double PI = 3.14;
	public default double calArea (double a, double b, double c) {
		double area = 0;
		double t;
		if(a>b) {
			t = a;
			a = b;
			b = t;
		}if(a>c) {
			t = a;
			a = c;
			c = t;
		}if(b>c) {
			t = b;
			b = c;
			c = t;
		}
		if(a+b<=c) {
			area = -1;
		}else {
			double p = (a+b+c)/2;
			area = Math.sqrt(p * (p-a) * (p-b) *(p-c));
		}
		return area;
	}
	public default double calArea (double r) {
		double area = 0;
		if(r<0) {
			area = -1;
		}else {
			area = PI * r*r;
		}
		return area;
	}
}

class Triangle extends Shape implements ShapeArea {/*定义子类Triangle，继承Shape，实现接口ShapeArea；*/
	public double calRound (double a, double b, double c) {/*子类Triangle要有计算周长的方法。*/
		double t;
		if(a>b) {
			t = a;
			a = b;
			b = t;
		}if(a>c) {
			t = a;
			a = c;
			c = t;
		}if(b>c) {
			t = b;
			b = c;
			c = t;
		}
		if(a+b<=c) {
			round = -1;
		}else {
			round = a + b + c;
		}
		return round;
	}
}

class Circle extends Shape implements ShapeArea {/*定义子类Circle，继承Shape，实现接口ShapeArea；*/
	public double calRound (double r) {/*子类Circle要有计算周长的方法。*/
		if(r<0) {
			round = -1;
		}else {
			round = 2 * PI * r;
		}
		return round;
	}
	public double calR (double area) {/*Circle类中定义方法，可以根据输入的面积计算圆的半径*/
		double r;
		if(area<0) {
			r = -1;
		}else {
			r = Math.sqrt(area / PI);
		}
		return r;
	}
}

public class Test5 {
	private static Scanner scan;
	private static Matcher m;
	private static Pattern p;

	public static void main(String [] args) {
		String s = "";
		int flag;
		double r=0,area=0;
		String sa,sb,sc,sr,sarea;
		double a=0,b=0,c=0;
		double round;
		while(true) {
			System.out.println("输入测试形状，三角形（Triangle） 或是 圆（ Circle） ？或是停止程序： 停（stop/exit）。");
			scan = new Scanner(System.in);
			s = scan.nextLine();
			if(s.equals("Triangle")||s.equals("triangle")||s.equals("三角形")) {
				while(true) {
					System.out.println("请在一行里输入三角形三边a,b,c:");
					scan = new Scanner(System.in);
					s = scan.nextLine();
					p = Pattern.compile("\\d+(\\.\\d+)?");  
			        m = p.matcher(s);
			        flag = 0;
			        while(m.find()) {
			        	flag++;
			        }
					if(m.find(0)) {
						sa = m.group();
						a = Double.valueOf(sa);
					}if(m.find()) {
						sb = m.group();
						b = Double.valueOf(sb);
					}if(m.find()) {
						sc = m.group();
						c = Double.valueOf(sc);
					}
					if(flag!=3||s.indexOf("-")!=-1) {
						System.out.println("边长输入错误，请重新输入！");
					}else {
						Triangle triangle = new Triangle ();
						area = triangle.calArea(a,b,c);
						round = triangle.calRound(a, b, c);
						if(area<0||round<0) {
							System.out.println("边长输入错误，请重新输入！");
						}else {
							System.out.println("三角形的面积是：");
							System.out.println(area);
							System.out.println("三角形的周长是：");
							System.out.println(round);
							break;
						}
					}
				}
			}else if(s.equals("Circle")||s.equals("circle")||s.equals("圆")) {
				while(true) {
					System.out.println("请输入圆的半径r:");
					scan = new Scanner(System.in);
					s = scan.nextLine();
					p = Pattern.compile("\\d+(\\.\\d+)?");  
			        m = p.matcher(s);
			        flag = 0;
			        while(m.find()) {
			        	flag++;
			        }
			        if(m.find(0)) {
						sr = m.group();
						r = Double.valueOf(sr);
					}
			        if(flag!=1||s.indexOf("-")!=-1) {
			        	System.out.println("半径输入错误，请重新输入！");
			        }else {
			        	Circle circle = new Circle();
			        	area = circle.calArea(r);
			        	round = circle.calRound(r);
			        	if(area<0||round<0) {
			        		System.out.println("半径输入错误，请重新输入！");
			        	}else {
				        	System.out.println("圆的面积是：");
							System.out.println(area);
							System.out.println("圆的周长是：");
							System.out.println(round);
							while(true) {
								System.out.println("请输入圆的面积area:");
								scan = new Scanner(System.in);
								s = scan.nextLine();
								p = Pattern.compile("\\d+(\\.\\d+)?");  
								m = p.matcher(s);
								flag = 0;
								while(m.find()) {
									flag++;
								}
								if(m.find(0)) {
									sarea = m.group();
									area = Double.valueOf(sarea);
								}
								if(flag!=1||s.indexOf("-")!=-1) {
									System.out.println("面积输入错误，请重新输入！");
								}else {
									r = circle.calR(area);
									if(r<0) {
										System.out.println("面积输入错误，请重新输入！");
									}else {
										System.out.println("圆的半径为：");
										System.out.println(r);
										break;
									}
								}
							}
							break;
			        	}
			        }
				}
			}else if(s.equals("stop")||s.equals("exit")||s.equals("停")){
				break;
			}else{
				System.out.println("找不到输入类型，请重新输入！");
			}
		}
	}
}
