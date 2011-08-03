// Here recursion is demonstrated.

class CountDown {
	public static void countdown(int n) {
		if (n == 0) {
			System.out.println("Blastoff!");
		} else {
			System.out.println(n);
			countdown(n - 1);
		}
	}

	public static void main(String[] args) {
		int n = 1000;
		countdown(n);
	}
}