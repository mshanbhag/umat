// 6.3 composition
import com.omnesys.*; 

@SuppressWarnings("unused")
class CircleArea {
	public static double area(double radious) {
		return Math.PI * radious * radious;

	}

	public static double distance(double x1, double y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		double dsquared = dx * dx + dy * dy;
		double result = Math.sqrt(dsquared);
		return result;
	}

	public static double area(double xc, double yc, double xp, double yp) {
		return area(distance(xc, yc, xp, yp));
	}

	public static void main(String[] args) {
		int x = -1;
		boolean isPositive = (x > 0);
		if (isPositive == true) {
			System.out.println("Number is positive");
		} else {
			System.out.println("Number is negative");
		}
		System.out.println(isSingleDigit(x));

	}

	public static boolean isSingleDigit(int x) {
		return (x >= 0 && x < 10);

	}
}
