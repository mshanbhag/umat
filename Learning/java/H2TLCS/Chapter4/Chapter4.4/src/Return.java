// here we use simple return number.

class Return {
	public static void main(String[] args) {
		double x = Math.random() * 100;
		double y = Math.random();
		int z;
		if (y < 0.5) {
			z = -1;
		} else {
			z = 1;
		}
		double a = x * z;
		TheReturn.printLogarithm(a);
	}
}