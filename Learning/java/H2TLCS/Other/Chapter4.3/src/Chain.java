/***
 * In this program, we generate 2 random numbers. one random number will decide
 * the sign of the another number which will be multiplied by 100 and converted
 * to int. Now we can tell if number is positive, negative or zero
 */

class Chain {
	public static void main(String[] args) {
		int x = (int) (Math.random() * 100);
		double y = Math.random();
		int z;
		if (y < 0.5) {
			z = -1;
		} else {
			z = 1;
		}
		int a = x * z; 
		if (a > 0) {
			System.out.println("a is positive");
		} else if (a < 0) {
			System.out.println("a is negative");
		} else {
			System.out.println("a is zero");
		}
	}
}