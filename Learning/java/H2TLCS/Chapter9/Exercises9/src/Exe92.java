//

public class Exe92 {
	public static int pow(int x, int n) {
		if (n == 0)
			return 1;
		// find x to the n/2 recursively
		int t = pow(x, n / 2);
		// if n is even, the result is t squared
		// if n is odd, result is t squared times x
		if (n % 2 == 0) {
			return t * t;
		} else {
			return t * t * x;
		}
	}

	public static void main(String[] args) {
		System.out.println(pow(9, 9));
	}
}