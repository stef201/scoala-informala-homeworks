package siit.homewotk10;

import java.util.concurrent.LinkedBlockingQueue;

public class FestivalGate {

	private LinkedBlockingQueue<TicketType> gate;

	public FestivalGate(LinkedBlockingQueue<TicketType> gate) {
		this.gate = gate;
	}

	public TicketType take() throws InterruptedException {
		return gate.take();
	}

	public boolean isEmpty() {
		return gate.isEmpty();
	}

	public void put(TicketType type) throws InterruptedException {
		gate.put(type);
	}
	
	
}
