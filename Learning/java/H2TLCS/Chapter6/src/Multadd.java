// Create a new program called Multadd.java
// write a method which takes three doubles as inputs and computes its multadditionization 

class Multadd {
	public static double multadd(double a, double b, double c) {
		return a * b + c;
	}

	public static double yikes(double x) {
		return multadd(x, Math.E * Math.exp(-x),
				Math.sqrt(1 - Math.E * Math.exp(-x)));
	}

	public static void main(String[] args) {
		double a = 1.0;
		double b = 2.0;
		double c = 3.0;
		System.out.println(multadd(a, b, c));

		double x = Math.sin(0.25);
		double y = Math.cos(0.25);
		System.out.println(multadd(y, 0.5, x));

		System.out.println(yikes(100.25));
	}
}