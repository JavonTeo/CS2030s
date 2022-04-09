// @author Javon Teo (Group 14J)
public class ArrivalEvent extends Event {
  private Customer customer;
  private Shop shop;

  public ArrivalEvent(double time, Customer customer, Shop shop) {
    super(time);
    this.customer = customer;
    this.shop = shop;
  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s arrived %s", this.customer, this.shop.getEntQueue());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    Counter availCounter = this.customer.goServCounter(this.shop);
    if (availCounter != null) {
      return new Event[] {
        new ServiceBeginEvent(this.getTime(), this.customer, availCounter, this.shop)
      };
    }
    Counter availCounterQueue = this.customer.goCounterQueue(this.shop);
    if (availCounterQueue != null) {
      return new Event[] {
        new JoinCounterQueueEvent(this.getTime(), this.customer, availCounterQueue)
      };
    }
    boolean entQueueFull = this.shop.entQueueFull();
    if (entQueueFull) {
      return new Event[] { 
        new DepartureEvent(this.getTime(), this.customer, this.shop)
      };
    }
    return new Event[] {
      new JoinEntQueueEvent(this.getTime(), this.customer, this.shop)
    };
  }
}
