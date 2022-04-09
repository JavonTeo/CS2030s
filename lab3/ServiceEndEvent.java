// @author Javon Teo (Group 14J)
public class ServiceEndEvent extends Event {
  private Customer customer;
  private Counter counter;
  private Shop shop;

  public ServiceEndEvent(double time, Customer customer, Counter counter, Shop shop) {
    super(time);
    this.customer = customer;
    this.counter = counter;
    this.shop = shop;
  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s service done (by %s)", this.customer, this.counter);
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    this.shop.setCounterStatus(this.counter, true);
    if (this.shop.entQueueEmpty()) {
      if (this.counter.emptyQueue()) {
        return new Event[] { 
          new DepartureEvent(this.getTime(), this.customer, this.shop),
        };
      } else {
        Customer nextCounterCustomer = this.counter.deqQueue();
        return new Event[] { 
          new DepartureEvent(this.getTime(), this.customer, this.shop),
          new ServiceBeginEvent(this.getTime(), nextCounterCustomer, this.counter, this.shop),
        };
      }
    } else {
      Customer nextEntCustomer = this.shop.deqEntQueue();
      if (this.counter.emptyQueue()) {
        return new Event[] { 
          new DepartureEvent(this.getTime(), this.customer, this.shop),
          new ServiceBeginEvent(this.getTime(), nextEntCustomer, this.counter, this.shop),
        };
      }
      Customer nextCounterCustomer = this.counter.deqQueue();
      return new Event[] { 
        new DepartureEvent(this.getTime(), this.customer, this.shop),
        new ServiceBeginEvent(this.getTime(), nextCounterCustomer, this.counter, this.shop),
        new JoinCounterQueueEvent(this.getTime(), nextEntCustomer, this.counter),
      };
    }
  }
}
