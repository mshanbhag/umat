/***
 * A friend of yours shows you following method and explains that if number is
 * any two digit number, the program will output the number backwards. He claims
 * that if number is 17, the method will output 71.
 * 
 */
public class Exe84 {
	public static void back(int i) {
		int lastDigit = i % 10;
		int firstDigit = i / 10;
		System.out.print(lastDigit);
		System.out.print(firstDigit);
	}

	public static void main(String[] args) {
		back(95);
	}
}
