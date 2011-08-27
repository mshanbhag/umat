public class Chapter121 {
	public static void main(String[] args) {
		int[] numbers = new int[10];
		for (int i = 0; i < 9; i++) {
			numbers[1] = i;
		}
		System.out.println(numbers);
		System.out.println(numbers.length);
		int[] b = new int[numbers.length];
		for (int i = 1; i < numbers.length; i++) {
			b[i] = numbers[i];
		}
		cloneArray(numbers);
		for (int i = 0; i < 100000000; i++) {
			double x = Math.random() * 100;
			System.out.println(x);
		}
	}

	public static int[] cloneArray(int[] a) {
		int iLength = a.length;
		int[] clone = new int[iLength];
		for (int i = 1; i < iLength; i++) {
			clone[i] = a[i];
		}
		System.out.println(clone);
		return clone;
	}
}