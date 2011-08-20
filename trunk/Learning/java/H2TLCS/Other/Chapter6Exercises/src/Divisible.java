// Exercises 6.1
// Write a class method names isDevisible that takes two integers
// n and m that returns true if n is divisible by M and false otherwise.

class Devisible {
	public static boolean isDivisible(int a, int b) {
		return (a % b == 0);
	}

	public static void main(String[] args) {
		int n = 22;
		int m = 3;
		System.out.println(isDivisible(n, m));
	}

}