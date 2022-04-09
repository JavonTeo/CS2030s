// @author Javon Teo (Group 14J)
public class Shop {
  private Array<Counter> counters;
  private Queue<Customer> entQueue;

  public Shop(int num, int maxCounterQueueLen, int maxEntQueueLen) {
    Array<Counter> counters = new Array<Counter>(num);
    for (int i = 0; i < num; i++) {
      Counter counter = new Counter(i, true, maxCounterQueueLen);
      counters.set(i, counter);
    }
    this.counters = counters;
    this.entQueue = new Queue<Customer>(maxEntQueueLen);
  }

  public Counter checkAvailCounters() {
    for (int i = 0; i < this.counters.getSize(); i++) {
      Counter counter = this.counters.get(i);
      if (counter.getAvail()) {
        return counter;
      }
    }
    return null;
  }

  public Counter findCounterQueue() {
    Counter goTo = counters.min();
    if (goTo.fullQueue()) {
      return null;
    } else {
      return goTo;
    }
  }
  
  public void setCounterStatus(Counter counter, boolean status) {
    counter.setAvail(status);
  }

  public Queue<Customer> getEntQueue() {
    return this.entQueue;
  }

  public boolean entQueueFull() {
    return this.entQueue.isFull();
  }

  public boolean entQueueEmpty() {
    return this.entQueue.isEmpty();
  }

  public boolean enqEntQueue(Customer customer) {
    return this.entQueue.enq(customer);
  }

  public Customer deqEntQueue() {
    return this.entQueue.deq();
  }
}
