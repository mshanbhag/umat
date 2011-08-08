// Demonstration of While Statement 

public class Countdown {
	public static void countdown(int n) {
		try {
			while (n > 0) {
				System.out.println(n);
				n = n - 1;
				Thread.currentThread();
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
		}
		System.out.println("Blastoff !!!!");
	}

	public static void sequence(int n) {
		while (n != 1) {
			System.out.println(n);
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = n * 3 + 1;
			}
		}
	}

	public static void main(String[] args) {
		int n = 11111;
		// countdown(n);
		sequence(n);
	}
}