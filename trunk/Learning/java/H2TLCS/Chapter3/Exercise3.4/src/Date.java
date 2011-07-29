// Initially this solution requires working solution of 2.2

class Date {
	public static void printAmerican(String day, int date, String month,
			int year) {
		System.out.print(day);
		System.out.print(", ");
		System.out.print(month);
		System.out.print(" ");
		System.out.print(date);
		System.out.print(", ");
		System.out.println(year);
	}
	
	public static void printEuropean(String day, int date, String month, int year) {
		System.out.print(day);
		System.out.print(", ");
		System.out.print(date);
		System.out.print(" ");
		System.out.print(month);
		System.out.print(", ");
		System.out.print(year);
	}

	public static void main(String[] args) {
		String day = "Friday";
		int date = 29;
		String month = "July";
		int year = 2011;
		printAmerican(day, date, month, year);
		printEuropean(day, date, month, year);
	}

}