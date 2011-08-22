// 1) Class name will always begin with Capital letter.
// 2) Put one class definition in one file. Name of the file must be same with the name 
//    of the class
// 3) One class is designated as a startup class. Startup class must contain a method named main. 
//    This is where execution of a program begins. Other classes may have method named main
//    which may not be executed.

public class Chap111 {
	public static void main(String[] args) {
		Time t1 = new Time();
		t1.hour = 11;
		t1.minute = 8;
		t1.second = 3.14159;
		System.out.println(t1);
		// another way to do same thing
		Time t2 = new Time(11, 9, 3.14159);
		System.out.println(Time.after(t1, t2));
	}
}
