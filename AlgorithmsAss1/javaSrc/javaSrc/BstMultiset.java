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
			root.count++;
			System.out.println("dup" + root.count);
			return root;
		}
		return root;
	}
	public int search(T item) 
	{
		Node temp = root;
		temp = searchAgain(temp, item);
		// Implement me!
		// default return, please override when you implement this method
		if(temp == null)
		{
			System.out.println("error");
			return 0;
		}
		else
		{
			return temp.count;
		}
	} // end of add()

	public Node searchAgain(Node root, T item)
	{
		if(root == null || item.toString().compareTo(root.key) == 0)
		{
			return root;
		}
		
		if(item.toString().compareTo(root.key) < 0)
		{
			//System.out.println(root.key);
			return searchAgain(root.leftChild, item);
		}
		else
		{
			//System.out.println(root.key);
			return searchAgain(root.rightChild, item);
		}
		
	}
	public void removeOne(T item)
	{
		Boolean all = false;
		root = deleteNode(root, item, all);
		
		// Implement me!
		} // end of removeOne()
	
	public Node deleteNode(Node temp, T item, Boolean all)
	{
		if(temp == null)
		{
			return temp;
		}
		if(temp.key.compareTo(item.toString()) > 0)
		{
			temp.leftChild = deleteNode(temp.leftChild, item, all);
		}
		else if(temp.key.compareTo(item.toString()) < 0)
		{
			temp.rightChild = deleteNode(temp.rightChild, item, all);
		}
		else
		{
			if(temp.count >= 2 && all == false)
			{
				temp.count--;
			}
			else
			{
				if(temp.leftChild == null && temp.rightChild == null)
				{
					temp = null;
				}
				else if(temp.rightChild == null)
				{
					temp = temp.leftChild;
				}
				else if(temp.leftChild == null)
				{
					temp = temp.rightChild;
				}
				else
				{
					Node minRight = findSmallestRight(temp.rightChild);
					temp.key = minRight.key;
					temp.count = minRight.count;
					@SuppressWarnings("unchecked")
					T item1 = (T) minRight.key;
					temp.rightChild = deleteNode(temp.rightChild, item1, all);
				}
			}
		}
		return temp;
	}
	
	public Node findSmallestRight(Node current)
	{
		while(current.leftChild != null)
		{
			current = current.leftChild;
		}
		return current;
	}
	public void removeAll(T item)
	{
		// Implement me!
		boolean all = true;
		root = deleteNode(root, item, all);
	} // end of removeAll()

	
	public void print(PrintStream out)
	{
		printData(root);
		out.println();
		// Implement me!
	} // end of print()
	public void printData(Node current)
	{
		if(current != null)
		{
			printData(current.leftChild);
			System.out.println(current.key + " | " + current.count);
			printData(current.rightChild);
		}
	}
} // end of class BstMultiset
