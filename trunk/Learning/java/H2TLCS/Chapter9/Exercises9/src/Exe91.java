// Exercise 9.1
import java.awt.Point;

public class Exe91 {
	public static void main(String[] args) {
		int x = 5;
		Point blank = new Point(1, 2);

		System.out.println(riddle(x, blank));
		System.out.println(x);
		System.out.println(blank.x);
		System.out.println(blank.y);
	}

	public static int riddle(int x, Point p) {
		x = x + 7;
		return x + p.x + p.y;
	}
}