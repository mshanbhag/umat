public class Counting {
	public static void main(String[] args) {
		String fruit = "MADHUSOODAN";
		int length = fruit.length();
		int count = 0;
		
		int index = 0;
		while (index < length) {
			if (fruit.charAt(index) == 'a') {
				count = count + 1;
			}
			index = index + 1;
		}
		System.out.println(count);
		System.out.println(fruit.toLowerCase());
	}
}