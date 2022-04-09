// @author Javon Teo (Group 14J)
public class DepartureEvent extends Event {
	private Customer cus;

	public DepartureEvent(double time, Customer cus) {
		super(time);
		this.cus = cus;
	}

	@Override
	public String toString() {
		String str = "";
		str = String.format(": %s departed", this.cus);
		return super.toString() + str;
	}
	
	@Override
	public Event[] simulate() {
		return new Event[] {};
	}
}
