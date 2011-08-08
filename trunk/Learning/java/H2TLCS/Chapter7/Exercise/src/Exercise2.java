// finding squre root

public class Exercise2 {
	public static void main(String[] args) {
		System.out.println(squareroot(65));
	}

	public static double squareroot(double a) {
		double x0 = a / 2;
		double x1 = (x0 + a / x0) / 2;
		while (Math.abs(x1 - x0) > 0.0001) {
			x0 = x1;
			x1 = (x0 + a / x0) / 2;
		}
		return x1;
	}
}