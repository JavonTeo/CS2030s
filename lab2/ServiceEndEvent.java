// @author Javon Teo (Group 14J)
public class ServiceEndEvent extends Event {
  private Customer cus;
  private Counter counter;
  private Shop shop;
  
  public ServiceEndEvent(double time, Customer cus, Counter counter, Shop shop) {
    super(time);
    this.cus = cus;
    this.counter = counter;
    this.shop = shop;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s service done (by %s)", this.cus, this.counter);
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    this.shop.setStatus(this.counter, true);
    return new Event[] { 
      new DepartureEvent(this.getTime(), this.cus, this.shop),
    };
  }
}
