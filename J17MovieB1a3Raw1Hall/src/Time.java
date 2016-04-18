import java.io.Serializable;

public class Time implements Serializable {
	private int hour;
	private int min;

	public Time(int hour, int min) {
		if (min < 0 || min > 59) {
			System.out.println("Error: min must be between 0-59");
			throw new IllegalArgumentException();
		} else {
			this.min = min;
		}
		if (hour < 0 || hour > 23) {
			System.out.println("Error: min must be between 0-59");
			throw new IllegalArgumentException();
		} else {
			this.hour = hour;
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min < 0 || min > 59) {
			System.out.println("Error: min must be between 0-59");
			throw new IllegalArgumentException();
		} else {
			this.min = min;
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 23) {
			System.out.println("Error: min must be between 0-59");
			throw new IllegalArgumentException();
		} else {
			this.hour = hour;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
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
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String h = "" + hour;
		String m = "" + min;
		if (hour < 10) {
			h = 0 + h;
		}
		if (min < 10) {
			m = 0 + m;
		}
		return h + "h," + m + "m";
	}
}
