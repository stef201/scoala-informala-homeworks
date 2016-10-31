package siit.homewotk10;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Assert;
import org.junit.Test;

public class TestFestivalGateIntegration {

	@Test
	public void integrationTest() {
		Random random = new Random();
		int noOfTicketsSold = 500;
		int threadPoolSize = random.nextInt(100) + 100;
		System.out.println("Thread pool size: " + threadPoolSize);
		LinkedBlockingQueue<TicketType> queue = new LinkedBlockingQueue<>();
		FestivalGate gate = new FestivalGate(queue);
		ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
		FestivalStatisticsThread stat = new FestivalStatisticsThread(gate, noOfTicketsSold);
		executor.execute(stat);
		for (int i = 0; i < noOfTicketsSold; i++) {
			int x = random.nextInt(5);
			TicketType ticketType = TicketType.values()[x];
			Runnable festivalAttendee = new FestivalAttendeeThread(ticketType, i * random.nextInt(1000), gate);
			executor.execute(festivalAttendee);
		}
		executor.shutdown();
		try {
			Thread.currentThread().sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int actual = stat.getNoOfTicketsProcessed();
		// then
		Assert.assertEquals(noOfTicketsSold, actual);

	}
}
