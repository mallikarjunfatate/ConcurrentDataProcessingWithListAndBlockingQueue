package ConcurrentDataProcessingListBlockingqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
//import java.util.*;
public  class TrasanctionHistory  // implements List<Transaction> (abstract methods implements)
{
	final List<Transaction> trasanctionList;
	
	public TrasanctionHistory()
	{
		this.trasanctionList = new ArrayList<Transaction>();
	}
	
	public int size() 
	{
		synchronized (trasanctionList) 
		{	
			return trasanctionList.size();
		}
	}

	public List<Transaction> getTrasanctionList()
	{
		synchronized (trasanctionList) 
		{			
			return trasanctionList;
		}
	}
	
	public boolean add(Transaction transaction)
	{
		synchronized (trasanctionList) 
		{			
			return trasanctionList.add(transaction);
		}
	}

	public boolean remove(Object transaction) 
	{	
		synchronized (trasanctionList) 
		{			
			return trasanctionList.remove(transaction);
		}
	}
	
	public Transaction remove(int index) 
	{
		synchronized (trasanctionList) 
		{			
			return trasanctionList.remove(index) ;
		}
	}
	
	public boolean retainAll(Collection<?> trasanction) 
	{
		synchronized (trasanction) 
		{			
			return trasanctionList.retainAll(trasanction);
		}
	}
	public Iterator<Transaction> iterator() {
		
		return trasanctionList.iterator();
	}
	
	
	
	
//	public boolean contains(Object transaction) 
//	{
//		return trasanctionList.contains(transaction);
//	}

//	public boolean containsAll(Collection<?> transaction) 
//	{
//		synchronized (transaction) 
//		{			
//			return trasanctionList.containsAll(transaction);
//		}
//	}
//
//	
//	public boolean removeAll(Collection<?> trasanction) 
//	{
//		synchronized (trasanction)
//		{			
//			return trasanctionList.removeAll(trasanction);
//		}
//	}

//	@Override
//	public Transaction get(int index)
//	{
//		synchronized (trasanctionList) 
//		{
//			return trasanctionList.get(index);
//		}
//	}
//
//	@Override
//	public Transaction set(int index, Transaction element) {
//		synchronized (trasanctionList) 
//		{
//			return trasanctionList.set(index, element);
//		}
//	}
//
//	@Override
//	public void add(int index, Transaction element) 
//	{
//		synchronized (trasanctionList) 
//		{
//			trasanctionList.add(element);
//		}
//	}
//

	
}
