import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	
	private Node root;
	
	public class Node
	{
		String key;
		Node leftChild;
		Node rightChild;
		int count;
		
		public Node(String item)
		{
			this.key = item;
			this.leftChild = null;
			this.rightChild = null;
			this.count = 0;
		}
	}
	public BstMultiset() 
	{
		this.root = null;
		
		// Implement me!
	} // end of BstMultiset()

	public void add(T item) 
	{
		root = addAgain(root, item);
		// Implement me!
	} // end of add()
	

	public Node addAgain(Node root, T item)
	{
		if(root == null)
		{
			root = new Node(item.toString());
			root.count++;
			return root;
		}
		
		if(item.toString().compareTo(root.key) < 0)
		{
			root.leftChild = addAgain(root.leftChild, item);
			
		}
		else if(item.toString().compareTo(root.key) > 0)
		{
			root.rightChild = addAgain(root.rightChild, item);
			
		}
		else
		{
			System.out.println(root.key);
			++root.count;
			System.out.println(root.key + root.count);
			return root;
		}
		return root;
	}
	public int search(T item) 
	{
		
		root = searchAgain(root, item);
		// Implement me!
		// default return, please override when you implement this method
		if(root == null)
		{
			return 0;
		}
		else
		{
			return root.count;
		}
	} // end of add()

	public Node searchAgain(Node root, T item)
	{
		if(root == null)
		{
			return root;
		}
		
		if(item.toString().compareTo(root.key) < 0)
		{
			root.rightChild = searchAgain(root.rightChild, item);
		}
		else
		{
			 root.leftChild = searchAgain(root.leftChild, item);
		}
		return root;
	}
	public void removeOne(T item)
	{
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item)
	{
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out)
	{
		// Implement me!
	} // end of print()

} // end of class BstMultiset
