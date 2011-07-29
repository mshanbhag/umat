//time calculation
class Time {
  public static void main(String[] args) {
    double hour = 11;
    double minute = 59;
    System.out.print("The number of minutes since midnight");
    System.out.println((hour * 60) + minute);
    System.out.print("Fraction of minute that has passed: ");
    System.out.println(minute / 60);
    System.out.print("Percentage of the hour that has passed: ");
    System.out.println((minute * 100) / 60);
  }
}
