/**
 *
 * @author Madhusoodan
 *
 */
class Hello {
  /***
   * This method contains new line function
   */
  public static void newLine() {
    System.out.println("");
  }

  /***
   * This is 3 new line function
   */
  public static void threeLine() {
    newLine();
    newLine();
    newLine();
  }

  /***
   * This method prints anything twice
   */
  public static void printTwice(String s) {
    System.out.println(s);
    System.out.println(s);
  }
}
