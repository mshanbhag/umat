// Using tables

public class Log {
	public static void main(String[] args) {
		double x = 1.0;
		while (x < 100) {
			System.out.println(x + " "+ Math.log(x)/ Math.log(2.0));
			x = x*2;
		}
	}
}