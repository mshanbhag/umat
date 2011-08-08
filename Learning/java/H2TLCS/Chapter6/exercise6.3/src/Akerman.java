public class Akerman {
	public static long ack(long m, long n) {
		if (m == 0) return n = 1;
		if (n == 0) return ack(m - 1, 1);
		return ack(m - 1, ack(m, n - 1));
	}
}