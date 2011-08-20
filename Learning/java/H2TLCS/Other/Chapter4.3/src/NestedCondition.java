// This will demonstrate nested conditions.

class NestedCondition {
	public static void main(String[] args) {
		int x = (int) (Math.random() * 100);
		double y = Math.random();
		int z;
		if (y < 0.5) {
			z = -1;
		} else {
			z = 1;
		}
		int a = x * z;
		if (a == 0) {
			System.out.println("a is zero");
		} else {
			if (a > 0) {
				System.out.println("a is positive1");

			} else {
				System.out.println("a is negative1");
			}
		}
	}
}