// @author Javon Teo (Group 14J)
public class Shop {
	private Counter[] counters;

	public Shop(int num) {
		Counter[] counters = new Counter[num];
		this.counters = counters;
		for (int i = 0; i < num; i++) {
			counters[i] = new Counter(i, true);
		}
	}

	public Counter checkAvail() {
		for (Counter x: counters) {
			if (x.getAvail()) {
				return x;
			}
		}
		return null;
	}

	public void setStatus(Counter counter, boolean status) {
		counter.setAvail(status);
	}
}
