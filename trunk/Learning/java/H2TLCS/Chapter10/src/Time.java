/***
 * Class time. Syntax for a constructor is similar to that of other methods with
 * three exceptions. 1) The name of the constructor is same as the name of the
 * class. 2) Constructors have no return type and no return value. 3) The
 * keyword static is omitted.
 * 
 */

public class Time {
	int hour;
	int minute;
	double second;

	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0.0;
	}

	public Time(int hour, int minute, double second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public static boolean after(Time time1, Time time2) {
		if (time1.hour > time2.hour)
			return true;
		if (time1.hour < time2.hour)
			return false;
		if (time1.minute > time2.minute)
			return true;
		if (time1.minute < time2.minute)
			return false;
		if (time1.second > time2.second)
			return true;
		return false;
	}
}
