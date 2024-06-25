package ConcurrentDataProcessingListBlockingqueue;

import java.util.concurrent.BlockingQueue;

public class TransactionProcessor implements Runnable
{
	BlockingQueue<Transaction> blockingTrasanctionQueue;
	TrasanctionHistory trasanctionHistory;
	
	public TransactionProcessor( BlockingQueue<Transaction> transactionQueue,
			TrasanctionHistory transactionHistory ) 
	{
        this.blockingTrasanctionQueue = transactionQueue;
        this.trasanctionHistory = transactionHistory;
    }

	@Override
	public void run()
	{
		try {
			while(true)
			{
				// Taking transaction from blocking queue 
				Transaction transaction = blockingTrasanctionQueue.take();
				trasanctionProcessor(transaction);
			}
		} catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("TransactionProcessor interrupted");
        }
	}

	private void trasanctionProcessor(Transaction transaction) 
	{
		// adding transaction 
		System.out.println("Transaction processing : "+ transaction);
		trasanctionHistory.add(transaction);
	}
}
