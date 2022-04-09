// @author Javon Teo (Group 14J)
public class JoinCounterQueueEvent extends Event {
  private Customer customer;
  private Counter counter;
  
  public JoinCounterQueueEvent(double time, Customer customer, Counter counter) {
    super(time);
    this.customer = customer;
    this.counter = counter;
  }
  
  @Override
  public String toString() {
    String str = String.format(": %s joined counter queue (at %s)", this.customer, this.counter);
    str = super.toString() + str;
    return str;
  }
  
  @Override
  public Event[] simulate() {
    boolean added = this.counter.enqQueue(this.customer);
    return new Event[] {};
  }
}

