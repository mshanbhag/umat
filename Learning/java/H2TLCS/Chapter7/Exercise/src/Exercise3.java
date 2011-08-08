// factorial

public class Exercise3 {
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
	
	public static int factorial(int x) {
		int iTemp = 1;
		int answer = 1;
		while (iTemp <= x) {
			 answer = answer * iTemp;
			iTemp = iTemp+1;
		}
		return answer;
	}
}