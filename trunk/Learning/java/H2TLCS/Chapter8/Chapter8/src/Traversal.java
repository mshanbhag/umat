public class Traversal {
	public static void main(String[] args) {
		backwards("madhusoodan");
	}

	public static void backwards(String s) {
		int index = s.length()-1;
		System.out.println(index);
		while (index >=0) {
			char letter = s.charAt(index);
			System.out.println(letter);
			index = index -1;
		}
	}
}