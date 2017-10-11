package circle;
import java.util.*;
public class TestCircle {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String [] args) {
		double r;
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		System.out.println("The r of c1 is:");
		r = scan.nextDouble();
		c1.setR(r);
		c1.Perimeter();
		c1.Acreage();
		System.out.println("The r of c2 is:");
		r = scan.nextDouble();
		c2.setR(r);
		c2.Perimeter();
		c2.Acreage();
		System.out.println("c1's perimeter is " + c1.getPerimeter());
		System.out.println("c1's acreage is " + c1.getAcreage());
		System.out.println("c2's perimeter is " + c2.getPerimeter());
		System.out.println("c's acreage is " + c2.getAcreage());
	}
}
