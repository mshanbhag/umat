// here we test fermat last theorem

class Fermat {
	public static int riseToPow(int a, int b) {
		int x = (int) (Math.pow(a, b));
		return x;
	}

	public static void main(String[] args) {
		for (int i = 3; i < 10; i++) {

			for (int j = 3; j < 10; j++) {

				for (int k = 3; k < 10; k++) {

					int p = riseToPow(i, j);
					int q = riseToPow(j, j);
					int r = riseToPow(k, j);
					fermatValidation(p, q, r);
				}
			}
		}
	}

	public static void fermatValidation(int a, int b, int c) {
		if (a + b == c) {
			System.out.println(a + " " + b + " " + c+ " Holy smokes, Fermat was wrong!");

		} else {
			System.out.println("No, that does not work");
		}
	}
}