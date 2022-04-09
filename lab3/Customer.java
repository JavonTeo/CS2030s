// @author Javon Teo (Group 14J)
public class Customer {
  private int id;
  private double servTime;
  
  public Customer(int id, double servTime) {
    this.id = id;
    this.servTime = servTime;
  }
  
  @Override
  public String toString() {
    return "C" + this.id;
  }
  
  public double getServTime() {
    return this.servTime;
  }

  public Counter goServCounter(Shop shop) {
    Counter anyCounterAvailable = shop.checkAvailCounters();
    return anyCounterAvailable;
  }
  
  public Counter goCounterQueue(Shop shop) {
    Counter anyCounterQueueAvailable = shop.findCounterQueue();
    return anyCounterQueueAvailable;
  }
}
