// @author Javon Teo (Group 14J)
public class ArrivalEvent extends Event {
  private Customer cus;
  private Shop shop;

  public ArrivalEvent(double time, Customer cus, Shop shop) {
    super(time);
    this.cus = cus;
    this.shop = shop;
  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s arrived %s", this.cus, this.shop.getQueue());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    boolean queueFull = this.shop.getQueue().isFull();
    if (queueFull) {
      return new Event[] { 
        new DepartureEvent(this.getTime(), this.cus, this.shop)
      };
    } else {
      Counter counter = this.shop.checkAvail();
      if (counter != null) {
        return new Event[] {
          new ServiceBeginEvent(this.getTime(), this.cus, counter, this.shop)
        };
      } else {
        return new Event[] {
          new JoinQueueEvent(this.getTime(), this.cus, this.shop)
        };
      }
    }
  }
}
