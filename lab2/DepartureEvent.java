// @author Javon Teo (Group 14J)
public class DepartureEvent extends Event {
  private Customer cus;
  private Shop shop;
  
  public DepartureEvent(double time, Customer cus, Shop shop) {
    super(time);
    this.cus = cus;
    this.shop = shop;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s departed", this.cus);
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    if (this.shop.getQueue().isEmpty()) {
      return new Event[] {};
    } else {
      Counter counter = this.shop.checkAvail();
      if (counter == null) {
        return new Event[] {};
      } else {
        Customer firstCus = (Customer) this.shop.getQueue().deq();
        return new Event[] {
          new ServiceBeginEvent(this.getTime(), firstCus, counter, this.shop)
        };
      }
    }
  }
}
