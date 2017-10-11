package circle;

public class Circle {
	static double PI = 3.14159;
	private double r;
	private double perimeter;
	private double acreage;
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	public double getAcreage() {
		return acreage;
	}
	public void setAcreage(double acreage) {
		this.acreage = acreage;
	}
	public void Perimeter() {
		perimeter = 2 * PI * r;
	}
	public void Acreage() {
		acreage = PI * r * r;
	}
}
