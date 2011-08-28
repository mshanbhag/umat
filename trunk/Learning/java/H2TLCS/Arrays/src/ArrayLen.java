/***
 * @author Madhusoodan
 */
public class ArrayLen {
    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[10];

        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        for (int iNum = 0; iNum < 100; iNum++) {
            int x = (int) (Math.random() * 100);

            System.out.println(x);
        }
        int numValues = 8;
        int[] array = randomArray(numValues);

        printArray(array);
    }

    /***
     * This array clones a given array and returns another array.
     * @param a (array to clone)
     * @return (cloned array)
     */
    public static int[] cloneArray(int[] a) {
        int[] aTempArray = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            aTempArray[i] = a[i];
        }
        return aTempArray;
    }

    /***
     * This method returns an random array of the size of integer input.
     * @param n (an integer of the size of expected array)
     * @return array[] with random element 
     */
    public static int[] randomArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = randomInt(10, 100);
        }
        return a;
    }

    /***
     * This method generates a random integer between given range. Range should be between
     * 0-100. 
     * @param a (lower range limit)
     * @param b (Higher ranger limit)
     * @return random integer between a and b
     */
    public static int randomInt(int a, int b) {
        int i = 0;

        while (i < a && i > b) {
            i = (int) (Math.random() * 100);
        }
        return i;
    }

    /***
     * This method prints components of an array
     * @param a (input array)
     */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
