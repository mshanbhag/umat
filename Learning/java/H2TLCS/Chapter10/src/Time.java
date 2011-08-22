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

	public static Time addTime(Time t1, Time t2) {
		Time sum = new Time();
		sum.hour = t1.hour + t2.hour;
		sum.minute = t1.minute + t2.minute;
		sum.second = t1.second + t2.second;

		if (sum.second >= 60.0) {
			sum.second -= 60.0;
			sum.minute += 1;
		}
		if (sum.minute >= 60) {
			sum.minute -= 60;
			sum.hour += 1;
		}
		return sum;
	}

	public static void increment(Time time, double secs) {
		time.second += secs;

		if (time.second >= 60.0) {
			time.second -= 60.0;
			time.minute += 1;
		}
		if (time.minute >= 60) {
			time.minute -= 60;
			time.hour += 1;
		}
	}
}
