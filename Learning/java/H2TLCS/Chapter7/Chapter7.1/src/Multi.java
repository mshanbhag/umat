// Printing multiple of 2

public class Multi {
	public static void main(String[] args) {
		int i = 11;

		printMultiTable(i, i);
	}

	public static void printMultiTable(int n, int high) {
		int i = 1;
		while (i <= high) {
			printMultiples(i, high);
			i = i + 1;
		}
	}

	public static void printMultiples(int n, int high) {
		int i = 1;
		while (i <= high) {
			System.out.print(n * i + " ");
			i = i + 1;
		}
		System.out.println("");
	}
}