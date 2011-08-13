/**
 * charAt example
 */

public class Charat {
	public static void main(String[] args) {
		String fruit = "banana";
		char letter = fruit.charAt(1);
		int length = fruit.length();
		System.out.println(letter);
		System.out.println(length);
		System.out.println(fruit.charAt(length-1));
	}
}
