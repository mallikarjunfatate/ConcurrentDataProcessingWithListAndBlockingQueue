package ConcurrentDataProcessingListBlockingqueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass 
{
	public static void main(String[] args) 
	{
		BlockingQueue<Transaction> transactionQueue = new ArrayBlockingQueue<Transaction>(100);
		TrasanctionHistory transactionHistory = new TrasanctionHistory(); 
		
//		for (int i = 1; i <= 5; i++) {
//            transactionQueue.add(new Transaction("T" + i, "BUY", Math.random() * 1000));
//        }
	
		 // Create a fixed thread pool for processing transactions
        ExecutorService executorService = Executors.newFixedThreadPool(5);
		
        // Start transaction producer threads
        for (int i = 0; i < 2; i++) 
        {
            executorService.submit(new TransactionProducer(transactionQueue));
        }
        // Start transaction processor threads
        for (int i = 0; i < 3; i++) 
        {
            executorService.submit(new TransactionProcessor(transactionQueue, transactionHistory));
        }	
        
        try 
        {
            Thread.sleep(10000); // Run for 10 seconds
        }
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }

        executorService.shutdownNow();
        
//        System.out.println("BlockingQueue contents : ");
//        
//        for (Transaction transaction : transactionQueue) 
//        {
//            System.out.println(transaction);
//        }
        
       System.out.println("Final Transaction History :: "); 
       for (Transaction transaction : transactionHistory.trasanctionList )
       {
    	   System.out.println(transaction);
       }
	}
}
