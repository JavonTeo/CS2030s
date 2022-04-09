// @author Javon Teo (Group 14J)
public class ServiceBeginEvent extends Event {
  private Customer customer;
  private Shop shop;
  private Counter counter;
  
  public ServiceBeginEvent(double time, Customer customer, Counter counter, Shop shop) {
    super(time);
    this.customer = customer;
    this.counter = counter;
    this.shop = shop;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s service begin (by %s)", this.customer, this.counter);
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    this.shop.setCounterStatus(counter, false);
    double endTime = this.getTime() + this.customer.getServTime();
    return new Event[] { 
      new ServiceEndEvent(endTime, this.customer, this.counter, this.shop)
    };
  }
}
