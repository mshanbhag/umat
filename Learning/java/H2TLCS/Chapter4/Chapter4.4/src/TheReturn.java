
public class TheReturn {
	public static void printLogarithm(double x) {
		if (x <= 0.0) {
			System.out.println("Positive numbers only, Please.");
			return;
		}
		double result = Math.log(x);
		System.out.println("The log of x is: " + result);
	}

}
