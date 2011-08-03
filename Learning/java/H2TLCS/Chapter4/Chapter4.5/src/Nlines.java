// printing n blank lines
// demonstrating recursion.
// such methods are called as recursive.

class Nlines {
	public static void main (String[] args) {
		int n = 15;
		nLines(n);
	}
	public static void nLines(int n) {
		if (n>0) {
			System.out.println(" ");
			nLines(n-1);
		} else {
			System.out.println("Task is over");
		}
	}
}