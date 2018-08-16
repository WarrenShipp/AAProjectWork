import java.io.PrintStream;
import java.util.*;



public class SortedLinkedListMultiset<T> extends Multiset<T>
{	private Node head;
	private Node current;
	private Node previous;
	
	public SortedLinkedListMultiset() {
		this.head =null;
		this.current= null;
		this.previous = null;
	} // end of SortedLinkedListMultiset()
	
	public class Node
	{
		Node next;
		Node previous;
		T item;
		
		public Node(T item){
			this.item=item;
		}
	}

	
	public void add(T item) {
		
		Node node = new Node(item);
		
		if (head==null ){
			//node.next=head;
			node.next = null;
			head = node;
			return;
		}
		if(head.item.toString().compareTo(node.item.toString())>0){
		
			node.next = head;
			head = node;
			return;
			
		}
		
			current = head.next;
			previous = head;
			while(current!=null){
				if(current.item.toString().compareTo(node.item.toString())>0){
					System.out.println("greater");
					//Node temp = current.next;
					//current.next = node;
					previous.next = node;
					node.next = current;
					return;
				}else{
					previous=previous.next;
					current=current.next;
				}
			}
			
		previous.next = node;
		return;
		}
	 
	
	
	public int search(T item) {
	
				current = head;
				int count = 0;
				
				if(current == null )
				{
					return 0;
				}
				while(current != null)
				{
					if(current.item.toString().equals(item))
					{
						count++;
					}
					current = current.next;
				}
	
				return count;
	}
	
	
	public void removeOne(T item) {
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
		
	} // end of removeOne()
	
	
	public void removeAll(T item) {
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
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node temp=head;
		
		//System.out.println("Checked");
		
		while(temp!=null){
			int count = search(temp.item);
			out.println(temp.item + " | " +count);
			temp = temp.next;
			
			
		}
		out.println();
	} // end of print()
	
} // end of class SortedLinkedListMultiset