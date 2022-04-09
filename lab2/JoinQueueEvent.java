// @author Javon Teo (Group 14J)
public class JoinQueueEvent extends Event {
  private Customer cus;
  private Shop shop;
  
  public JoinQueueEvent(double time, Customer cus, Shop shop) {
    super(time);
    this.cus = cus;
    this.shop = shop;
  }
  
  @Override
  public String toString() {
    String str = String.format(": %s joined queue %s", this.cus, this.shop.getQueue());
    str = super.toString() + str;
    return str;
  }
  
  @Override
  public Event[] simulate() {
    boolean added = this.shop.getQueue().enq(this.cus);
    return new Event[] {};
  }
}

