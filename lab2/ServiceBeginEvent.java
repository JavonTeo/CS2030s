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
    str = String.format(": %s service begin (by %s)", this.cus, this.counter);
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    this.shop.setStatus(counter, false);
    double endTime = this.getTime() + this.cus.getserTime();
    return new Event[] { 
      new ServiceEndEvent(endTime, this.cus, this.counter, this.shop)
    };
  }
}
