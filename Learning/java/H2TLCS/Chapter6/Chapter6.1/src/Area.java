class Area {
	public static double area(double radious) {
		return Math.PI * radious * radious;

	}

	public static double absoluteValue(double x) {
		if (x < 0) {
			return -x;
		} else {
			return x;
		}
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		double dsquared = dx * dx + dy * dy;
		double result = Math.sqrt(dsquared);
		return result;
	}

	public static void main(String[] args) {
		double x = 1;
		double y = area(x);
		System.out.println(y);
		double a = distance(1.0, 2.0, 4.0, 6.0);
		System.out.println(a);
	}
}