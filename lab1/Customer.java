// @author Javon Teo (Group 14J)
public class Customer {
	private int id;
	private double arrTime;
	private double serTime;

	public Customer(int id, double arrTime, double serTime) {
		this.id = id;
		this.arrTime = arrTime;
		this.serTime = serTime;
	}
	
	@Override
	public String toString() {
		return "Customer "+id;
	}

	public double getarrTime() {
		return this.arrTime;
	}

	public double getserTime() {
		return this.serTime;
	}
}
