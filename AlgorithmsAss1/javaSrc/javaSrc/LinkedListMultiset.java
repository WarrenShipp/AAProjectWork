import java.io.PrintStream;
import java.util.*;

/*
 * LinkedListMultiset is a child of Multiset. by extends we inherit all the properties
 * of the parent class.
 */

public class LinkedListMultiset<T> extends Multiset<T> {

	/*
	 * declaration and initialization of variable to be used in the code it has
	 * been set to private to prevent variable from being unwanted access from
	 * different class and package.
	 */
	private Node head;
	private Node previous;
	private Node current;
	private Node tail;
	private int num;
	private int index;

	/*
	 * a constructor will no arguments that set/initialized variable to null or
	 * zero 0
	 */
	public LinkedListMultiset() {
		this.head = null;
		this.previous = null;
		this.current = null;
		this.tail = null;
		this.num = 0;

	} // end of LinkedListMultiset() constructor

	/*
	 * A node class with four variable, two variable are of type Node and one
	 * Boolean and another multiset type. Initially a boolean value is set to
	 * false to indicate that none of the item has been printed.
	 */

	public class Node {
		Node next;
		Node previous;
		T item;
		Boolean printed = false;

	}

	/*
	 * This is an add method that does not return any value. it takes one
	 * argument of type multiset. this method add new item into a single
	 * link-list based on FIFO until there is no more item left to be added.
	 */
	public void add(T item) {
		// Implement me!
		Node node = new Node();
		node.item = item;

		if (head == null) {
			head = node;
		} else {
			current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}

	} // end of add()

	/*
	 * This method is used to search an item and return to the calling function
	 * once found. it take one Multiset type called item as arguments. it
	 * searches for an item in the link-list by comparing the item to be search
	 * with item present in the link-list. it keep on searching until no item is
	 * left to be compared with and finally return its value of type Integer.
	 * (non-Javadoc)@see Multiset#search(java.lang.Object)
	 */
	public int search(T item) {
		// Implement me!
		current = head;
		int count = 0;

		if (current == null) {
			return 0;
		}
		while (current != null) {
			if (current.item.equals(item)) {
				current.printed = true;
				count++;
			}
			current = current.next;
		}
		// default return, please override when you implement this method
		return count;
	} // end of add()

	/*
	 * This method keep track of the item printed to avoid print method remember
	 * its previous state.
	 */
	public void clearPrint() {
		current = head;
		while (current != null) {
			current.printed = false;
			current = current.next;
		}
	}

	/*
	 * This method is implemented to remove a single item from a link-list. it
	 * takes on arguments called item which is to be removed.
	 */
	public void removeOne(T item) {

		if (head == null) {
			return;
		}

		current = head.next;
		previous = head;

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
	/*
	 * removeAll method is to remove all the item from the link-list. it takes
	 * one arguments which is to be removed.
	 */

	public void removeAll(T item) {
		Node remove;
		if (head == null) {
			return;
		}

		previous = head;
		current = head.next;

		while (current != null) {
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
		if (head.item.equals(item)) {
			current = head;
			head = current.next;
			current = null;
			return;
		}
	}

	// end of removeAll()

	/*
	 * This method print all the item in each separate group and count the
	 * number of present in the link-list.
	 */
	public void print(PrintStream out) {
		Node temp = head;

		// a call to clearPrint method.
		clearPrint();
		while (temp != null) {

			// to avoid multiple print. it check and make sure that it has not
			// been printed before.
			if (temp.printed == false) {
				int count = search(temp.item);
				out.println(temp.item + printDelim + count);

			}
			temp = temp.next;

		}
		out.println();
	}
}
// end of class LinkedListMultiset