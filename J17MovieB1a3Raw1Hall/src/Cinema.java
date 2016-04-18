import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cinema {
	TreeMap<Days, Schedule> cinema;
	Time open = new Time(9, 0);
	Time close = new Time(23, 0);

	public Cinema() {
		this.cinema = new TreeMap<Days, Schedule>();
	}

	public void cinemaFeel2() {
		addSeance(Days.TUE, new Seance("1Sw4ing", 1, 3, 2, 15, 2));
		addSeance(Days.TUE, new Seance("1Sw4ing", 1, 3, 4, 15, 3));
		addSeance(Days.TUE, new Seance("1Sw4ing", 1, 3, 5, 15, 1));
		addSeance(Days.TUE, new Seance("1S3w4ing", 1, 3, 6, 15, 1));
		addSeance(Days.TUE, new Seance("1S2w4ing", 1, 3, 9, 15, 3));
		addSeance(Days.TUE, new Seance("1Sw4ing", 1, 3, 12, 15, 2));
		addSeance(Days.TUE, new Seance("1Sw4ing", 1, 3, 15, 15, 3));
		addSeance(Days.TUE, new Seance("1Sw54ing", 1, 3, 22, 15, 1));
		addSeance(Days.TUE, new Seance("1S4w4ing", 1, 3, 23, 15, 3));
		addSeance(Days.MON, new Seance("1Sw4ing", 1, 3, 2, 15, 2));
		addSeance(Days.MON, new Seance("1S3w4ing", 1, 3, 3, 15, 3));
		addSeance(Days.MON, new Seance("1Sw4ing", 1, 3, 4, 15, 1));
		addSeance(Days.MON, new Seance("1Sw44ing", 1, 3, 6, 15, 2));
		addSeance(Days.MON, new Seance("12Sw4ing", 1, 3, 7, 15, 3));
		addSeance(Days.MON, new Seance("1Sw45ing", 1, 3, 12, 15, 1));
		addSeance(Days.MON, new Seance("1S2w4ing", 1, 3, 15, 15, 2));
		addSeance(Days.MON, new Seance("1Sw44ing", 1, 3, 22, 15, 3));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 8, 15, 1));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 17, 15, 2));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 15, 15, 3));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 11, 15, 1));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 12, 15, 1));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 20, 15, 1));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 22, 15, 2));
		addSeance(Days.MON, new Seance("1Sw45ing", 1, 3, 12, 15, 2));
		addSeance(Days.MON, new Seance("1S2w4ing", 1, 3, 15, 15, 3));
		addSeance(Days.MON, new Seance("1Sw44ing", 1, 3, 22, 15, 1));
		addSeance(Days.FRI, new Seance("1Sw44ing", 1, 3, 8, 15, 3));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 17, 15, 3));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 15, 15, 2));
		addSeance(Days.FRI, new Seance("1Sw44ing", 1, 3, 11, 15, 2));
		addSeance(Days.SAT, new Seance("1Sw44ing", 1, 3, 12, 15, 2));
		addSeance(Days.FRI, new Seance("1Sw44ing", 1, 3, 20, 15, 2));
		addSeance(Days.FRI, new Seance("1Sw44ing", 1, 3, 22, 15, 1));
	}

	public void addSeance(Days d, Seance seance) {
		if (seance.getStartTime().getHour() < open.getHour() || seance.getStartTime().getHour() > close.getHour()) {
			System.out.println("You can add seance only on working hours: 9-23");
		} else {
			TreeMap<Days, Schedule> db = readFromFile("Schedule");
			if (fileCheck("Schedule")) {
				if (seanseCheck((TreeSet<Seance>) db.get(d).getSchedule(), seance)) {
					db.get(d).getSchedule().add(seance);
					writeToFile(db, "Schedule");
					printToFile(db, "CinemaSchedule.txt");
					printToFileLog("added seance on " + d + " " + seance.toString(), "CinemaScheduleLog.txt");
				}
			} else {
				db.get(d).getSchedule().add(seance);
				writeToFile(db, "Schedule");
				printToFile(db, "CinemaSchedule.txt");
				printToFileLog("added seance on " + d + " " + seance.toString(), "CinemaScheduleLog.txt");
			}
		}
	}

	public void addSeance(Days d) {
		Seance seance = new Seance().seance();
		if (seance.getStartTime().getHour() < open.getHour() || seance.getStartTime().getHour() > close.getHour()) {
			System.out.println("You can add seance only on working hours: 9-23");
		} else {
			TreeMap<Days, Schedule> db = readFromFile("Schedule");
			if (fileCheck("Schedule")) {
				if (seanseCheck((TreeSet<Seance>) db.get(d).getSchedule(), seance)) {
					db.get(d).getSchedule().add(seance);
					writeToFile(db, "Schedule");
					printToFile(db, "CinemaSchedule.txt");
					System.out.println("1 errrrrrrrrrrrrrrrr");
					printToFileLog("added seance on " + d + " " + seance.toString(), "CinemaScheduleLog.txt");
				}
			} else {
				db.get(d).getSchedule().add(seance);
				writeToFile(db, "Schedule");
				printToFile(db, "CinemaSchedule.txt");
				System.out.println("2 errrrrrrrrrrrrrrrr");
				printToFileLog("added seance on " + d + " " + seance.toString(), "CinemaScheduleLog.txt");
			}
		}
	}

	public Days scanDay() {
		System.out.println("Enter day");
		return Days.valueOf(Util.scan().next());
	}

	public void removeSeance() {
		System.out.println("To remove seance - enter day hour min");
		System.out.println("Enter day");
		String day = Util.scan().next();
		System.out.println("Enter hour");
		int hour = Util.scan().nextInt();
		System.out.println("Enter min");
		int min = Util.scan().nextInt();
		String f = "Schedule";
		if (fileCheck(f)) {
			boolean printer = false;
			TreeMap<Days, Schedule> db = readFromFile(f);
			Iterator<Seance> it = db.get(Days.valueOf(day)).getSchedule().iterator();
			while (it.hasNext()) {
				Seance temp = it.next();
				if (temp.getStartTime().getHour() == hour) {
					if (temp.getStartTime().getMin() == min) {
						it.remove();
						printer = true;
					}
				}
			}
			if (printer) {
				writeToFile(db, f);
				printToFile(db, "CinemaSchedule.txt");
				printToFileLog("removed seance on " + day + " " + hour + " " + min, "CinemaScheduleLog.txt");
			}
		}
	}

	public void removeMovie() {
		System.out.println("To remove movie - enter title");
		String title = Util.scan().nextLine();
		String f = "Schedule";
		if (fileCheck(f)) {
			boolean printer = false;
			TreeMap<Days, Schedule> db = readFromFile(f);
			Iterator<Entry<Days, Schedule>> it = db.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Days, Schedule> entry = it.next();
				Iterator<Seance> it2 = entry.getValue().getSchedule().iterator();
				while (it2.hasNext()) {
					Seance temp = it2.next();
					if (temp.getMovie().getTitle().equals(title)) {
						it2.remove();
					}
				}
			}
			if (printer) {
				writeToFile(db, f);
				printToFile(db, "CinemaSchedule.txt");
				printToFileLog("removed movie " + title, "CinemaScheduleLog.txt");
			}
		}
	}

	public void printCinemaSchedule() {
		if (fileCheck("Schedule")) {
			Iterator<Entry<Days, Schedule>> it = readFromFile("Schedule").entrySet().iterator();
			while (it.hasNext()) {
				Entry<Days, Schedule> entry = it.next();
				System.out.println(entry.getKey());
				entry.getValue().printSchedule();
			}
		}
	}

	public void printSceanceRoom(Seance seance) {
		if (fileCheck("Schedule")) {
			Iterator<Entry<Days, Schedule>> it = readFromFile("Schedule").entrySet().iterator();
			while (it.hasNext()) {
				Entry<Days, Schedule> entry = it.next();
				if (entry.getValue().getSchedule().contains(seance)) {
					TreeSet<Seance> temp = (TreeSet<Seance>) entry.getValue().getSchedule();
					for (Seance seance2 : temp) {
						if (seance2.equals(seance)) {
							printRoom(seance2.getRoomSeat());
						}
					}
				}
			}
		}
	}

	public void printToFile(TreeMap<Days, Schedule> db, String file) {
		Date d = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		Iterator<Entry<Days, Schedule>> it = db.entrySet().iterator();
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("CinemaSchedule.txt"));
			bw.flush();
			bw.close();
			bw = new BufferedWriter(new FileWriter("CinemaSchedule.txt", true));
			bw.write(format1.format(d));
			bw.newLine();
			while (it.hasNext()) {
				Entry<Days, Schedule> entry = it.next();
				bw.write(entry.getKey().toString());
				bw.newLine();
				Schedule seance = entry.getValue();
				Iterator<Seance> it1 = seance.schedule.iterator();
				while (it1.hasNext()) {
					Seance temp = it1.next();
					bw.write(temp.toString());
					bw.newLine();
				}
			}

			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printToFileLog(String pointer, String file) {
		Date d = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("CinemaScheduleLog.txt", true));
			bw.write(format1.format(d));
			bw.newLine();
			bw.write("=========" + pointer);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public void printToFileLog(TreeMap<Days, Schedule> db, String pointer,
	// String file) {
	// Date d = new Date();
	// SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
	// Iterator<Entry<Days, Schedule>> it = db.entrySet().iterator();
	// BufferedWriter bw;
	// try {
	// bw = new BufferedWriter(new FileWriter("CinemaScheduleLog.txt", true));
	// bw.write(format1.format(d));
	// bw.newLine();
	// bw.write("=========" + pointer);
	// bw.newLine();
	// while (it.hasNext()) {
	// Entry<Days, Schedule> entry = it.next();
	// // System.out.println(entry.getKey().toString());
	// bw.write(entry.getKey().toString());
	// bw.newLine();
	// Schedule seance = entry.getValue();
	// Iterator<Seance> it1 = seance.schedule.iterator();
	// while (it1.hasNext()) {
	// Seance temp = it1.next();
	// bw.write(temp.toString());
	// bw.newLine();
	// }
	// }
	//
	// bw.flush();
	// bw.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	public void printCinemaDaySchedule(Days d) {
		if (fileCheck("Schedule")) {
			readFromFile("Schedule").get(d).printSchedule();
		}
	}

	public void writeToFile(TreeMap<Days, Schedule> db, String f) {
		File file = new File(f);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(db);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TreeMap<Days, Schedule> readFromFile(String f) {
		TreeMap<Days, Schedule> fromFile = new TreeMap<>();
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			fromFile = (TreeMap<Days, Schedule>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			fromFile.put(Days.MON, new Schedule());
			fromFile.put(Days.TUE, new Schedule());
			fromFile.put(Days.WED, new Schedule());
			fromFile.put(Days.THU, new Schedule());
			fromFile.put(Days.FRI, new Schedule());
			fromFile.put(Days.SAT, new Schedule());
			fromFile.put(Days.SUN, new Schedule());
			return fromFile;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return fromFile;
	}

	private boolean fileCheck(String f) {
		File file = new File(f);
		if (file.isFile()) {
			return true;
		}
		System.out.println("Cant find file");
		return false;
	}

	private boolean seanseCheck(TreeSet<Seance> schedule, Seance seance) {
		if (!schedule.isEmpty()) {
			Iterator<Seance> it = schedule.iterator();
			ArrayList<Integer> start = new ArrayList<>();
			while (it.hasNext()) {
				Seance temp = it.next();
				if (temp.getRoomNumber() == seance.getRoomNumber()) {
					start.add(intStringInt(temp.getStartTime().getHour(), temp.getStartTime().getMin()));
					start.add(intStringInt(temp.getEndTime().getHour(), temp.getEndTime().getMin()) + 15);
				}
			}
			int seanceStart = intStringInt(seance.getStartTime().getHour(), seance.getStartTime().getMin());
			int seanceEnd = intStringInt(seance.getEndTime().getHour(), seance.getEndTime().getMin() + 15);
			start.add(seanceStart);
			start.add(seanceEnd);
			Collections.sort(start);
			System.out.println("start index " + start.indexOf(seanceStart));
			System.out.println(seanceStart);
			System.out.println("end index " + start.indexOf(seanceEnd));
			System.out.println(seanceEnd);
			int a = start.indexOf(seanceStart);
			int b = start.indexOf(seanceEnd);
			if (!((a + 1) == b)) {
				System.out.println("1Error: this time already feeled");
				return false;
			}
			if (!((a + 2) % 2 == 0) && (b + 2) % 2 > 0) {
				System.out.println("a " + (a + 2) % 2);
				System.out.println("b " + (b + 2) % 2);
				System.out.println("2Error: this time already feeled");
				return false;
			}
			System.out.println("true");
			System.out.println(start.toString());
		}
		return true;
	}

	private static int intStringInt(int hour, int min) {
		int result = 0;
		if (hour < 9) {
			hour = hour + 24;
		}
		if (min > 59) {
			min = min - 60;
			hour = hour + 1;
		}
		result = hour * 60 + min;
		return result;
	}

	private static void printRoom(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			if (!temp.isEmpty() && i > 0) {
				temp = list.get(i).substring(0, 2) + "  " + list.get(i).substring(3).replace('1', (char) '\u25A1');
				temp = list.get(i).substring(0, 3) + temp.substring(3).replace('2', (char) '\u25A0');
				temp = list.get(i).substring(0, 3) + temp.substring(3).replace('3', (char) '\u25CF');
				System.out.println(temp);
			} else {
				System.out.println(list.get(i));
			}
		}
	}
}
