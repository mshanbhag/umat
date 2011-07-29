// just to check if random number is bigger than 0.5

class Random {
	public static void main(String[] args) {
		int moreThan = 0;
		int lessThan = 0;
		for (int i = 0; i < 100; i++) {
			int num = (int) (Math.random() * 100);
			if (num > 50) {
				moreThan = moreThan + 1;
				System.out.print(num);
				System.out.println(" is more than 50");
			} else {
				lessThan = lessThan + 1;
				System.out.print(num);
				System.out.println(" is less than 50");
			}
		}
		System.out.println(moreThan);
		System.out.println(lessThan);
		int num1 = (int) (Math.random() * 100);
		if (num1 % 2 == 0) {
			System.out.println("Num is even");
		} else {
			System.out.println("Num is odd");
		}
	}
}