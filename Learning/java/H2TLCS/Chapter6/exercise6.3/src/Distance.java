public class Distance {
	public static double sumSquares(double a, double b) {
		return 0.0;
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(sumSquares(x2 - x1, y2 - y1));
	}
}
