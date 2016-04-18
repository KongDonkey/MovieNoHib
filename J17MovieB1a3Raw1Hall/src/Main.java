
public class Main {

	public static void main(String[] args) {
		goOn();
	}

	public static void goOn() {
		int key;
		boolean lock = true;
		Cinema cinema = new Cinema();
		while (lock) {
			System.out.println("Enter key");
			System.out.println("1 to add seance manually");
			System.out.println("2 to add seance");
			System.out.println("3 to add seance");
			System.out.println("4 to prind schedule on 1 day");
			System.out.println("5 to print allweek schedule");
			System.out.println("6 to remove seance");
			System.out.println("7 to remove movie");
			System.out.println("8 to print seatmap on seance");
			System.out.println("12 to exit");
			key = Util.scan().nextInt();
			switch (key) {
			case 1:
				cinema.addSeance(cinema.scanDay());
				break;
			case 2:
				cinema.addSeance(Days.MON, new Seance("1Sw4ing", 1, 3, 12, 15, 1));
				cinema.addSeance(Days.MON, new Seance("1Sw4ing", 1, 3, 13, 15, 2));
				break;
			case 3:
				cinema.cinemaFeel2();
				break;
			case 4:
				cinema.printCinemaDaySchedule(cinema.scanDay());
				break;
			case 5:
				cinema.printCinemaSchedule();
				break;
			case 6:
				cinema.removeSeance();
				break;
			case 7:
				cinema.removeMovie();
				break;
			case 8:
				cinema.printSceanceRoom(new Seance("1Sw4ing", 1, 3, 12, 15, 1));
				break;
			case 11:
				cinema.cinemaFeel2();
				break;
			case 12:
				lock = false;
				break;
			default:
				break;
			}
		}
	}

}
