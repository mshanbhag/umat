//Seconds since midnight
class TimeInSeconds {
  public static void main(String[] args) {
    int hour = 7;
    int minute = 57;
    System.out.print("The time since midnight in seconds is: ");
    System.out.println((hour * 60 * 60) + (minute * 60));
  }
}
