public class Recurse {
	// First : returns the first character of the given string
	public static char first(String s) {
		return s.charAt(0);
	}

	// last : returns a new string that contains all but
	// the first letter of the given string
	public static String rest(String s) {
		return s.substring(1, s.length());
	}

	// length : returns the length of the given string.
	public static int length(String s) {
		return s.length();
	}
	
	public static void main(String[] args) {
		String m = "MadhusoodanPrabhakarShanbhag";
		System.out.println(first(m));
		System.out.println(rest(m));
		System.out.println(length(m));
	}
}