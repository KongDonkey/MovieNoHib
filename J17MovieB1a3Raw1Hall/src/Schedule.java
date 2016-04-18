import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule implements Serializable {
	Set<Seance> schedule;

	public Schedule() {
		this.schedule = new TreeSet<>();
	}

	public void printSchedule() {
		for (int i = 1; i < 4; i++) {
			Iterator<Seance> it = schedule.iterator();
			while (it.hasNext()) {
				Seance temp = it.next();
				if (temp.getRoomNumber() == i) {
					System.out.println(temp);
				}
			}
		}
	}

	public Set<Seance> getSchedule() {
		return schedule;
	}

	public void setSchedule(TreeSet<Seance> schedule) {
		this.schedule = schedule;
	}
}
