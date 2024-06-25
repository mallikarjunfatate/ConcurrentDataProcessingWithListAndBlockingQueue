package ConcurrentDataProcessingListBlockingqueue;

import java.util.concurrent.BlockingQueue;

public class TransactionProducer implements Runnable 
{
	BlockingQueue<Transaction> trasanctionQueue;
	
	public TransactionProducer(BlockingQueue<Transaction> trasanctionQueue) 
	{
		this.trasanctionQueue = trasanctionQueue;
	}
	
	@Override
	public void run() 
	{
		try {
			while(true)
			{	
				Transaction transaction = randamTrasanctionGenerate();
				trasanctionQueue.put(transaction);
				
				System.out.println("Transaction Producer : "+ transaction );
				Thread.sleep(500); // Simulate time delay between transaction generation
			}
		} 
		catch (InterruptedException e) 
		{
			Thread.currentThread().interrupt();
			System.out.println(" Transaction Producer interrupted ");
		}
	}

	private Transaction randamTrasanctionGenerate() 
	{		
		String trasanctionId = "T "+ System.currentTimeMillis();
		String trasanctionType = Math.random() >0.5 ? " Buy" : " Sell";
		double amount = Math.random() * 1000;
		return new Transaction( trasanctionId, trasanctionType, amount);
	}

}
