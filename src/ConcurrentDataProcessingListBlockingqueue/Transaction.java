package ConcurrentDataProcessingListBlockingqueue;

public class Transaction 
{
	private String trasanctionId;
	private String trasnctionType;
	private double amount;
	private long timeStamp;
	
 public Transaction(String trasanctionId,String trasanctionType, double amount)
	{
		this.trasanctionId =trasanctionId;
		this.trasnctionType = trasanctionType;
		this.amount =amount;
		this.timeStamp = System.currentTimeMillis();
	}
 
 public String getTrasanctionId() 
 {
	 return trasanctionId;
 }
 public String getTrasanctionType()
 {
	 return trasnctionType;
 }
 public double getAmount() {
	 return amount;
 }
 public long getTimeStap()
 {
	 return timeStamp;
 }
 
 @Override
public String toString()
 {
	return "Transaction [ trasanctionId = " + trasanctionId + ", timeStamp = " + timeStamp + ", trasnctionType = "
			+ trasnctionType + ", amount = " + amount + "]";
 }
}
