public class Traversal {
	public static void main(String[] args) {
		int index = 0;
		String fruit = "Banana";
		int length = fruit.length();
		while (index < length) {
			char letter = fruit.charAt(index);
			System.out.println(letter);
			index = index + 1;
		}
	}
}