// @author Javon Teo (Group 14J)
public class Shop {
  private Counter[] counters;
  private Queue queue;
  
  public Shop(int num, int maxQueueLen) {
    Counter[] counters = new Counter[num];
    this.counters = counters;
    for (int i = 0; i < num; i++) {
      counters[i] = new Counter(i, true);
    }
    this.queue = new Queue(maxQueueLen);
  }

  public Counter checkAvail() {
    for (int i = 0; i < this.counters.length; i++) {
      if (this.counters[i].getAvail()) {
        return this.counters[i];
      }
    }
    return null;
  }
  
  public void setStatus(Counter counter, boolean status) {
    counter.setAvail(status);
  }

  public Queue getQueue() {
    return this.queue;
  }
}
