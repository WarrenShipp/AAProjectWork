import java.io.PrintStream;
import java.util.*;

/*
 * SortedLinkedListMultiset is a child of Multiset. by extends we inherit all the properties
 * of the parent class.
 */
public class SortedLinkedListMultiset<T> extends Multiset<T> {
	/*
	 * declaration and initialization of variable to be used in the code it has
	 * been set to private to prevent variable from being unwanted access from
	 * different class and package.
	 */

	private Node head;
	private Node current;
	private Node previous;

	/*
	 * a constructor will no arguments that set/initialized variable to null.
	 */
	public SortedLinkedListMultiset() {
		this.head = null;
		this.current = null;
		this.previous = null;
	} // end of SortedLinkedListMultiset()

	/*
	 * A node class with three variable, two variable are of type Node and one
	 * of multiset type.
	 */
	public class Node {
		Node next;
		Node previous;
		T item;

		// a constructor that take item as an argument and set to the current
		// item.
		public Node(T item) {
			this.item = item;
		}
	}

	// a method to add an item in an ascending order.
	public void add(T item) {

		Node node = new Node(item);

		if (head == null) {
			// node.next=head;
			node.next = null;
			head = node;
			return;
		}
		/*
		 * it check whether the item to be inserted is smaller than the existing
		 * once. if it is greater the 0 indicating true. it will then insert at
		 * the beginning of the list
		 */

		if (head.item.toString().compareTo(node.item.toString()) > 0) {

			node.next = head;
			head = node;
			return;

		}

		current = head.next;
		previous = head;
		while (current != null) {
			/*
			 * it compares the item to be inserted in the middle of the
			 * link-list.
			 */
			if (current.item.toString().compareTo(node.item.toString()) > 0) {
				previous.next = node;
				node.next = current;
				return;
			}
			// this block of section set the item to be inserted at the end of
			// the list.
			else {
				previous = previous.next;
				current = current.next;
			}
		}

		previous.next = node;
		return;
	}

	// this method search the item in the link-list. item to be search is passed
	// as a parameter.
	public int search(T item) {

		current = head;
		int count = 0;

		// if the list is empty it return null.
		if (current == null) {
			return 0;
		}
		// it continue searching until the list has no more item to search.
		while (current != null) {
			if (current.item.toString().equals(item)) {
				count++;
			}
			current = current.next;
		}

		return count;
	}

	/*
	 * this method remove one item at a time. it takes an item to be remove as a
	 * parameter.
	 * 
	 */
	public void removeOne(T item) {

		if (head == null) {
			return;
		}

		current = head.next;
		previous = head;

		/*
		 * it search for a match untill the list is empty. once found it remove
		 * the item from the list and re-connect the link and join list again.
		 */

		while (current != null) {
			if (current.item.equals(item)) {
				previous.next = current.next;
				current = null;
				return;
			}
			previous = current;
			current = current.next;
		}

		if (head.item.equals(item)) {
			current = head;
			head = current.next;
			current = null;
			return;
		}

	} // end of removeOne()

	// a method to remove all the item present in the link-list. it takes an
	// item as a parameter
	public void removeAll(T item) {

		Node remove;
		if (head == null) {
			return;
		}

		previous = head;
		current = head.next;

		while (current != null) { // it find an item starting from the node next
									// to head. remove it once found.
			if (current.item.equals(item)) {
				previous.next = current.next;
				remove = current;
				current = previous.next;
				remove = null;

			}

			else {
				previous = current;
				current = current.next;
			}
		}
		// it check whether the head node contain the item to be removed. if it
		// true,
		// it will be removed as well.
		if (head.item.equals(item)) {
			current = head;
			head = current.next;
			current = null;
			return;
		}
	} // end of removeAll()

	/*
	 * this method prints all the item in the list to a console. it take a
	 * predefined outsteam object as a parameter.
	 */
	public void print(PrintStream out) {

		Node temp = head;

		while (temp != null) {
			int count = search(temp.item);

			if (temp.next == null) {
				out.println(temp.item + printDelim + count);
				temp = temp.next;
			}

			else {
				if (temp.item.toString().equals(temp.next.item.toString())) {

					temp = temp.next;
					continue;
				}

				else {
					out.println(temp.item + printDelim + count);
					temp = temp.next;
				}
			}

		}
		out.println();
	} // end of print()

} // end of class SortedLinkedListMultiset