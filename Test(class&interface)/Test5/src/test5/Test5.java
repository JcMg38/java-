package test5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
1.	������Shape���������ܳ���������ԣ�
2.	����ӿ�ShapeArea���ӿ����з������������
3.	��������Triangle��Circle��������������˼̳�Shape������Ҫʵ�ֽӿ�ShapeArea��
4.	����Triangle��CircleҪ�м����ܳ��ķ�����
5.	Circle���ж��巽�������Ը���������������Բ�İ뾶��
6.	��main�����в����������ܡ�
*/
class Shape {/*������Shape���������ܳ���������ԣ�*/
	protected double round;
	protected double area;
}

interface ShapeArea {/*����ӿ�ShapeArea���ӿ����з������������*/
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

class Triangle extends Shape implements ShapeArea {/*��������Triangle���̳�Shape��ʵ�ֽӿ�ShapeArea��*/
	public double calRound (double a, double b, double c) {/*����TriangleҪ�м����ܳ��ķ�����*/
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

class Circle extends Shape implements ShapeArea {/*��������Circle���̳�Shape��ʵ�ֽӿ�ShapeArea��*/
	public double calRound (double r) {/*����CircleҪ�м����ܳ��ķ�����*/
		if(r<0) {
			round = -1;
		}else {
			round = 2 * PI * r;
		}
		return round;
	}
	public double calR (double area) {/*Circle���ж��巽�������Ը���������������Բ�İ뾶*/
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
			System.out.println("���������״�������Σ�Triangle�� ���� Բ�� Circle�� ������ֹͣ���� ͣ��stop/exit����");
			scan = new Scanner(System.in);
			s = scan.nextLine();
			if(s.equals("Triangle")||s.equals("triangle")||s.equals("������")) {
				while(true) {
					System.out.println("����һ������������������a,b,c:");
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
						System.out.println("�߳�����������������룡");
					}else {
						Triangle triangle = new Triangle ();
						area = triangle.calArea(a,b,c);
						round = triangle.calRound(a, b, c);
						if(area<0||round<0) {
							System.out.println("�߳�����������������룡");
						}else {
							System.out.println("�����ε�����ǣ�");
							System.out.println(area);
							System.out.println("�����ε��ܳ��ǣ�");
							System.out.println(round);
							break;
						}
					}
				}
			}else if(s.equals("Circle")||s.equals("circle")||s.equals("Բ")) {
				while(true) {
					System.out.println("������Բ�İ뾶r:");
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
			        	System.out.println("�뾶����������������룡");
			        }else {
			        	Circle circle = new Circle();
			        	area = circle.calArea(r);
			        	round = circle.calRound(r);
			        	if(area<0||round<0) {
			        		System.out.println("�뾶����������������룡");
			        	}else {
				        	System.out.println("Բ������ǣ�");
							System.out.println(area);
							System.out.println("Բ���ܳ��ǣ�");
							System.out.println(round);
							while(true) {
								System.out.println("������Բ�����area:");
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
									System.out.println("�������������������룡");
								}else {
									r = circle.calR(area);
									if(r<0) {
										System.out.println("�������������������룡");
									}else {
										System.out.println("Բ�İ뾶Ϊ��");
										System.out.println(r);
										break;
									}
								}
							}
							break;
			        	}
			        }
				}
			}else if(s.equals("stop")||s.equals("exit")||s.equals("ͣ")){
				break;
			}else{
				System.out.println("�Ҳ����������ͣ����������룡");
			}
		}
	}
}
