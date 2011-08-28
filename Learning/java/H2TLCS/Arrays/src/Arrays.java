/***
 * Introduction to arrays.
 * 
 * @author Madhusoodan
 * 
 */

public class Arrays {
    public static void main(String[] args) {
        int[] count;

        // double[] values;
        count = new int[4];
        // values = new double[10];
        count[0] = 7;
        count[1] = count[0] * 2;
        count[2]++;
        count[3] -= 60;
        int i = 0;

        while (i < 4) {
            System.out.println(count[i]);
            i++;
        }
        for (int k = 0; k < 4; k++) {
            System.out.println(count[k]);
            i++;
        }
    }
    /***
     * in many ways arrays behave like objects
     * 1) When you declare an array variable, you get an reference to an array.
     * 2) you have to use new to create an array itself.
     * 3) When you pass an array as an argument, you pass a reference, which means that
     * an invoked method can change the content of an array.
     */
}
