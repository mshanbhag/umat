/***
 * If you are given three sticks, you may or may not be able to arrange them in
 * triangle. The simple rule for testing possibility of a triangle
 * 
 * if any of the three length is greater than sum of other two, then you can not
 * form a triangle, otherwise you can.
 * 
 * write a method named isTriangle that it takes three integers as its arguments
 * and returns true or false depending on whether you can or can not form a
 * triangle from sticks with the given lengths.
 */

class Triangle {
	public static boolean isTriangle(int a, int b, int c) {
		if (Math.max(Math.max(a, b), Math.max(c, b)) == a) {
			return (a > (b + c));
		} else {
			if (Math.max(Math.max(a, b), Math.max(c, b)) == b) {
				return (b > (a + c));
			} else {
				return (c > (a + b));
			}
		}
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 8;
		int c = 2;
		System.out.print(isTriangle(a, b, c));
	}
}
