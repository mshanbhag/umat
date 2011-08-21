public class Exe86 {
	public static char first(String s) {
		System.out.println(s.charAt(0));
		return s.charAt(0);
	}

	public static char last(String s) {
		System.out.println(s.charAt(s.length() - 1));
		return s.charAt(s.length() - 1);
	}

	public static String middle(String s) {
		System.out.println(s.substring(1, s.length() - 1));
		return s.substring(1, s.length() - 1);
	}

	public static boolean isPalindrome(String s) {
		int firstLetter = 0;
		int lastLetter = s.length() - 1;
		if (s.length() % 2 != 0) {
			return false;
		} else {
			while (firstLetter <= lastLetter) {
				if (s.charAt(firstLetter) == s.charAt(lastLetter)) {
					return true;
				}
				firstLetter++;
				lastLetter--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String name = "madhusoodan";
		char alpha = 'a';
		first("Madhusoodan");
		last("Madhusoodan");
		middle("Madhusoodan");
		System.out.println(isPalindrome("pabbap"));
		System.out.println(name.hashCode());
		System.out.println(alpha);
	}
}