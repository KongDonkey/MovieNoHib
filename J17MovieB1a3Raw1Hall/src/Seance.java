import java.io.Serializable;
import java.util.ArrayList;

public class Seance implements Comparable<Seance>, Serializable {
	private Movie movie;
	private Time startTime;
	private Time endTime;
	private String room;
	private int roomNumber;
	private ArrayList<String> roomSeat;

	public Seance() {
	}

	public Seance(String title, int hour, int min, int hourStart, int minStart, int room) {
		this.movie = new Movie(title, hour, min);
		this.startTime = new Time(hourStart, minStart);
		this.endTime = setEndTime(movie, startTime);
		this.roomNumber = room;
		if (room == 1) {
			this.roomSeat = radioactive();
			this.room = "\u2622 Radioactive";
		}
		if (room == 2) {
			this.roomSeat = dream();
			this.room = "\u263A Dream";
		}
		if (room == 3) {
			this.roomSeat = victory();
			this.room = "\u270C Victory";
		}
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public ArrayList<String> getPlace() {
		return roomSeat;
	}

	public String getRoom() {
		return room;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public ArrayList<String> getRoomSeat() {
		return roomSeat;
	}

	private Time setEndTime(Movie movie, Time startTime) {
		Time temp = new Time(0, 0);
		int tempMin = startTime.getMin() + movie.getDuration().getMin();
		int tempHour = startTime.getHour() + movie.getDuration().getHour();
		if (tempMin > 59) {
			tempMin = tempMin - 60;
			tempHour = tempHour + 1;
		}
		if (tempHour > 23) {
			tempHour = tempHour - 24;
		}
		temp.setMin(tempMin);
		temp.setHour(tempHour);
		return temp;
	}

	@Override
	public String toString() {
		return "  " + startTime + "  "+room + "\n          " + movie + "     " + endTime + "    ";
	}

	@Override
	public int compareTo(Seance o) {
		int res = this.getRoomNumber() - o.getRoomNumber();
		if (res == 0) {
			res = this.startTime.getHour() - o.startTime.getHour();
			if (res == 0) {
				res = this.startTime.getMin() - o.startTime.getMin();
			}
		}
		return res;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + roomNumber;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	public Seance seance() {
		System.out.println("Enter movie title");
		String title = Util.scan().nextLine();
		System.out.println("Enter duration - hours, then mins");
		int hour = Util.hour();
		int min = Util.min();
		System.out.println("Enter movie start time - hour, then mins");
		int hourStart = Util.hour();
		int minStart = Util.min();
		System.out.println("Choose hall: 1 for 'Radioactive', 2 for 'Dream', 3 for 'Victory'");
		int room = Util.roomNumber();
		return new Seance(title, hour, min, hourStart, minStart, room);
	}

	public static ArrayList<String> radioactive() {
		ArrayList<String> list = new ArrayList<>();
		list.add("\u2622          1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20");
		list.add("12  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("11  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("10  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("9   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("8   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("7   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("");
		list.add("6   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("5   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("4   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("3   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("2         1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("1         1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		return list;
	}

	public static ArrayList<String> dream() {
		ArrayList<String> list = new ArrayList<>();
		list.add("\u263A          1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20");
		list.add("12  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("11  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("10  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("9   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("8   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("7   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("");
		list.add("6   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("5   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("4   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("3   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("2         1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("1         1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		return list;
	}

	public static ArrayList<String> victory() {
		ArrayList<String> list = new ArrayList<>();
		list.add("\u270C           1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18");
		list.add("14  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("13  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("12  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("11  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("10  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("9   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("8   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("7   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("");
		list.add("6   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("5   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("4   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("3   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("2         1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		list.add("1         1  1  1  1  1  1  1  1  1  1  1  1  1  1");
		return list;
	}
}
