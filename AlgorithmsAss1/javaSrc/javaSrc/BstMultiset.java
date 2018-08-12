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
		
		public Node(T item)
		{
			this.key = item.toString();
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


	public Node addAgain(Node current, T item)
	{
		String itemStr = item.toString();
		if(root == null)
		{
			root = new Node(item);
			root.count++;
			return root;
		}
		if(itemStr.compareTo(root.key) < 0 )
		{
			root.leftChild = addAgain(root.leftChild, item);
		}
		else if(itemStr.compareTo(root.key) > 0)
		{
			root.rightChild = addAgain(root.rightChild, item);
		}
		else
		{
			root.count++;
			return root;
		}
		return root;
	}
	public int search(T item) 
	{
		// Implement me!

		// default return, please override when you implement this method
		return 0;
	} // end of add()


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
