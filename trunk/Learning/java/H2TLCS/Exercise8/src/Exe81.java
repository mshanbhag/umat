/***
 * The purpose of this exercise is to review the encapsulation and 
 * generalization
 */

/***
 * Encapsulate the following code fragment transforming it into a method that
 * takes a string as an argument and that returns the final value of count.
 * 
 * String s = "((3 + 7) * 2)"; int len = s.length(); int i = 0; int count = 0;
 * while (i < len) { char c = s.charAt(i); if (c == ’(’) { count = count + 1; }
 * else if (c == ’)’) { count = count - 1; } i = i + 1; }
 * System.out.println(count);
 */

public class Exe81 {
	public static void main(String[] args) {
		count("((3+7)*2)");
	}

	public static int count(String s) {
		int len = s.length();
		int iTemp1 = 0;
		int count = 0;
		while (iTemp1 < len) {
			char c = s.charAt(iTemp1);
			if (c == '(') {
				count = count + 1;
				System.out.println("count" + count);
			} else if (c == ')') {
				count = count - 1;
				System.out.println("count*" + count);
			}
			iTemp1++;
			System.out.println("iTemp1 " + iTemp1);
		}
		System.out.println(count);
		return count;
	}
}

/***
 * This code confirms that there are equal closing brackets for all opening
 * brackets.
 */
