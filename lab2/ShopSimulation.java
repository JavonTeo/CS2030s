import java.util.Scanner;

/**
 * This class implements a shop simulation.
 *
 * @author Wei Tsang
 * @version CS2030S AY21/22 Semester 2
 */ 

// @author Javon Teo (Group 14J)
class ShopSimulation extends Simulation {
  /** 
   * The availability of counters in the shop. 
   */

  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  public Event[] initEvents;

  /** 
   * Constructor for a shop simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public ShopSimulation(Scanner sc) {
    initEvents = new Event[sc.nextInt()];
    int numOfCounters = sc.nextInt();
    int maxQueueLen = sc.nextInt();

    Shop shop = new Shop(numOfCounters, maxQueueLen);

    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      Customer cus = new Customer(id, arrivalTime, serviceTime);
      initEvents[id] = new ArrivalEvent(arrivalTime, cus, shop);
      id += 1;
    }
  }

  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
