/*
 * @author SN
 */
package siit.homewotk10;

import java.util.Random;

/**
 * The Class FestivalAttendeeThread.
 */
public class FestivalAttendeeThread implements Runnable {

	FestivalGate gate;
	private TicketType type;
	private int ticketNumber;
	private Random random = new Random();

	/**
	 * Instantiates a new festival attendee thread.
	 *
	 * @param type
	 *            the type of the ticket
	 * @param ticketNo
	 *            the ticket number
	 * @param gate
	 *            the designated gate 
	 */
	public FestivalAttendeeThread(TicketType type, int ticketNo, FestivalGate gate) {
		this.type = type;
		this.ticketNumber = ticketNo;
		this.gate = gate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		processTicket();
	}

	/**
	 * Process the ticket.
	 */
	public void processTicket() {
			try {
				//System.out.println("xxx" + Thread.currentThread().getName().toString() + " - " + toString());
				
				gate.put(type);
				Thread.sleep(random.nextInt(2000) + 3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FestivalAttendeeThread [type=" + type + ", ticket number=" + ticketNumber + "]";
	}

}
