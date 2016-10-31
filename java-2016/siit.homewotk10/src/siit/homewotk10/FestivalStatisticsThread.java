/*
 * @author SN
 */
package siit.homewotk10;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class FestivalStatisticsThread.
 */
public class FestivalStatisticsThread implements Runnable {

	private FestivalGate gate;
	private int noOfTicketsSold;
	int noOfTicketsProcessed = 0;

	private Integer[] st = { 0, 0, 0, 0, 0 };

	/**
	 * Instantiates a new festival statistics thread.
	 *
	 * @param gate
	 *            the gate designated on the ticket
	 * @param noOfTicketsSold
	 *            the number of tickets sold
	 */
	public FestivalStatisticsThread(FestivalGate gate, int noOfTicketsSold) {
		this.gate = gate;
		this.noOfTicketsSold = noOfTicketsSold;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		generateStatistics();
	}

	/**
	 * Generate statistics.
	 */
	private void generateStatistics() {
		try {
			while ((st[0] + st[1] + st[2] + st[3] + st[4]) != noOfTicketsSold) {

			  TicketType ticketType;
			  ticketType = gate.take();
			  switch (ticketType) {
				case FULL:
					st[0] += 1;
					break;
				case FULL_VIP:
					st[1] += 1;
					break;
				case FREE_PASS:
					st[2] += 1;
					break;
				case ONE_DAY:
					st[3] += 1;
					break;
				case ONE_DAY_VIP:
					st[4] += 1;
					break;
			  }
			  if (gate.isEmpty()) {
					System.out.println(toString());
					noOfTicketsProcessed = (st[0] + st[1] + st[2] + st[3] + st[4]);
					System.out.println("	Tickets processed: " + noOfTicketsProcessed);
					Thread.currentThread();
					Thread.sleep(5000);
					if (gate.isEmpty()) {
						System.out.println("\nAll tickets processed.");
						this.setNoOfTicketsProcessed(noOfTicketsProcessed);
					}
			  }
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the noOfTicketsProcessed
	 */
	public int getNoOfTicketsProcessed() {
		return noOfTicketsProcessed;
	}

	/**
	 * @param noOfTicketsProcessed
	 *            the noOfTicketsProcessed to set
	 */
	public void setNoOfTicketsProcessed(int noOfTicketsProcessed) {
		this.noOfTicketsProcessed = noOfTicketsProcessed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String stat = "Statistics: " + "\n	Full = " + st[0] + "\n	Full_VIP = " + st[1] + "\n	Free_pass = " + st[2]
				+ "\n	One_Day = " + st[3] + "\n	Full = " + st[4];
		return stat;
	}
}
