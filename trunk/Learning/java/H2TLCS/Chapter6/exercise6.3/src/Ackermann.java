/**
 * The purpose of this exercise is to translate a recurcive defination into a java method.
 * The ackerman function is defined for non-negative integers as follows.
 * A(m,n) = if (m== 0) then n+1
 * 			if m > 0 and n = 0 then A (m-1,1);
 * 			if m > 0, n > 0 then A(m-1, a(m, n-1)) 
 */

public class Ackermann {

   public static long ackermann(long m, long n) {
      if (m == 0) return n + 1;
      if (n == 0) return ackermann(m - 1, 1);
      return ackermann(m - 1, ackermann(m, n - 1));
   }

   public static void main(String[] args) {
      long M = 3;
      long N = 9;
      System.out.println(ackermann(M, N));
   }
}