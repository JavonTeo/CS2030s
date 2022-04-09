// @author Javon Teo (Group 14J)
public class Counter implements Comparable<Counter> {
  private int id;
  private boolean available;
  private Queue<Customer> queue;
  
  public Counter(int id, boolean available, int maxCounterQueueLen) {
    this.id = id;
    this.available = available;
    this.queue = new Queue<Customer>(maxCounterQueueLen); //might need to Queue<Customer> instead
  }
  
  public boolean getAvail() {
    return this.available;
  }

  public int getId() {
    return this.id;
  }

  public boolean fullQueue() {
    return this.queue.isFull();
  }

  public boolean emptyQueue() {
    return this.queue.isEmpty();
  }
  
  public void setAvail(boolean status) {
    this.available = status;
  }

  public boolean enqQueue(Customer customer) {
    return this.queue.enq(customer);
  }

  public Customer deqQueue() {
    return (Customer) this.queue.deq();
  }

  @Override
  public String toString() {
    String str = String.format("S%d %s", this.id, this.queue);
    return str;
  }

  @Override
  public int compareTo(Counter counter) {
    if (this.queue.length() == counter.queue.length()) {
      return this.id > counter.getId() ? 1 : -1;
    } else if (this.queue.length() > counter.queue.length()) {
      return 1;
    } else {
      return -1;
    }
  }
}
