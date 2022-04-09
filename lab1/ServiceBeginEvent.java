// @author Javon Teo (Group 14J)
public class ServiceBeginEvent extends Event {
	private Customer cus;
	private Shop shop;
	private Counter counter;

	public ServiceBeginEvent(double time, Customer cus, Counter counter, Shop shop) {
		super(time);
		this.cus = cus;
		this.counter = counter;
		this.shop = shop;
	}

	@Override
	public String toString() {
		String str = "";
		str = String.format(": %s service begin (by Counter %d)", this.cus, this.counter.getId());
		return super.toString() + str;
	}
	
	@Override
	public Event[] simulate() {
		shop.setStatus(this.counter, false);
		double endTime = this.getTime() + this.cus.getserTime();
		return new Event[] { 
			new ServiceEndEvent(endTime, this.cus, 
					this.counter, this.shop)
		};
	}
}
