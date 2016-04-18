import java.util.Scanner;

public class Util {
	public static final Scanner scan() {
		return new Scanner(System.in);
	}

	public static final int min() {
		int min = Util.scan().nextInt();
		if (min > 59 || min < 0) {
			System.out.println("Error, mins can be only 0-59 ");
			System.out.println("Try again");
			return min();
		}
		return min;
	}

	public static final int hour() {
		int hour = Util.scan().nextInt();
		if (hour < 0 || hour > 23) {
			System.out.println("Error, hour can be 0-23 ");
			System.out.println("Try again");
			return hour();
		}
		return hour;
	}

	public static final int roomNumber() {
		int roomNumber = Util.scan().nextInt();
		if (roomNumber < 1 || roomNumber > 3) {
			System.out.println("Error, make valid choise - 1 for 'Radioactive', 2 for 'Dream', 3 for 'Victory'");
			return roomNumber();
		}
		return roomNumber;
	}
}
