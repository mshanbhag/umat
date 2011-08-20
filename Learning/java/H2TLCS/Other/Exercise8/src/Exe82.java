/***
 * This program prints index number in a String in inverted style, sums inverted
 * sequence of strings. and prints total inverted sequence.
 */

public class Exe82 {
	public static String mystery(String s) {
		int i = s.length() - 1;
		String total = "";

		while (i >= 0) {
			char ch = s.charAt(i);
			System.out.println(i + "  " + ch);
			total = total + ch;
			i--;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(mystery("Allen"));
	}
}