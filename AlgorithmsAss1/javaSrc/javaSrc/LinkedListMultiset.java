import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	
	private Node head;
	private Node previous;
	private Node current;
	private Node tail;
	private int num;
	private int index;
	
	public LinkedListMultiset() 
	{
		this.head = null;
		this.previous = null;
		this.current = null;
		this.tail = null;
		this.num = 0;
		
		// Implement me!
	} // end of LinkedListMultiset()
	
	public class Node
	{
		Node next;
		Node previous;
		T item;
		Boolean printed = false;
	
	}
	
	public void add(T item) 
	{
		// Implement me!
		Node node = new Node();
		node.item = item;
		
		if(head == null)
		{
			head = node;
		}
		else
		{
			current = head;
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = node;
		}
		
	} // end of add()
	
	
	public int search(T item) 
	{
		// Implement me!	
		current = head;
		int count = 0;
		
		if(current == null)
		{
			return 0;
		}
		while(current != null)
		{
			if(current.item.equals(item))
			{	
				current.printed = true;
				count++;
			}
			current = current.next;
		}
		// default return, please override when you implement this method
		return count;
	} // end of add()
	
	public void clearPrint()
	{
		current = head;
		while(current != null)
		{
			current.printed = false;
			current = current.next;
		}
	}
	
	public void removeOne(T item) 
	{
		
		if(head == null)
		{
			return;
		}
		
		current = head.next;
		previous = head;
		
		while(current != null)
		{
			if(current.item.equals(item))
			{
				previous.next = current.next;
				current = null;
				return;
			}
			previous = current;
			current = current.next;
		}
		if(head.item.equals(item))
		{
			current = head;
			head = current.next;
			current = null;
			return;
		}
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) 
	{
		Node remove;
		if(head == null)
		{
			return;
		}
		
		previous = head;
		current = head.next;
		
		while(current != null)
		{
			if(current.item.equals(item))
			{
				previous.next = current.next;
				remove = current;
				current = previous.next;
				remove = null;
				
			}
			
			else
			{
				previous = current;
				current = current.next;
			}
		}	
		if(head.item.equals(item))
		{
			current = head;
			head = current.next;
			current = null;
			return;
		}
	}	

	 // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node temp=head;
		
		//System.out.println("Checked");
		clearPrint();
		while(temp!=null)
		{
			
			if(temp.printed == false)
			{
				int count = search(temp.item);
				out.println(temp.item + "|" + count);
				
			}
			temp = temp.next;
			
		}
		out.println();
	}
}
 // end of class LinkedListMultiset