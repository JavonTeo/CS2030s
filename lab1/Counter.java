// @author Javon Teo (Group 14J)
public class Counter {
	private int id;
	private boolean available;

	public Counter(int id, boolean available) {
	       this.id = id;
		this.available = available;
	}

	public int getId() {
		return this.id;
	}

	public boolean getAvail() {
		return this.available;
	}

	public void setAvail(boolean status) {
		this.available = status;
	}
}
