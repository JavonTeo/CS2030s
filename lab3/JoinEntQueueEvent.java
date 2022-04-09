// @author Javon Teo (Group 14J)
public class JoinEntQueueEvent extends Event {
  private Customer customer;
  private Shop shop;
  
  public JoinEntQueueEvent(double time, Customer customer, Shop shop) {
    super(time);
    this.customer = customer;
    this.shop = shop;
  }
  
  @Override
  public String toString() {
    String str = String.format(": %s joined shop queue %s", this.customer, this.shop.getEntQueue());
    str = super.toString() + str;
    return str;
  }
  
  @Override
  public Event[] simulate() {
    boolean added = this.shop.enqEntQueue(this.customer);
    return new Event[] {};
  }
}

