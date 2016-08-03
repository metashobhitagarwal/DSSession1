package SinglyLinkedList;

public class MyLinkList<T> {

	Node<T> start;
	int size;

	public MyLinkList() {
		start = null;
		size = 0;
	}

	public boolean isEmpty() {
		return start == null;
	} 
	public int getSize() {
		return size;
	}

	/**
	 * This method will insert an item at specific location
	 * 
	 * @param val
	 * @param loc
	 */
	public void insertAtLoc(T val, int loc) {
		Node<T> nptr = new Node<T>(val, null);
		if (loc == 1 && start == null) {
			start = nptr;
			start.setLink(null);
		} else if (loc == 1) {
			nptr.setLink(start);
			start = nptr;
		} else {
			Node<T> ptr = start;
			loc = loc - 1;
			for (int i = 1; i <= size; i++) {
				if (i == loc) {
					Node<T> tmp = ptr.getLink();
					ptr.setLink(nptr);
					nptr.setLink(tmp);
					break;
				}
				ptr = ptr.getLink();
			}
		}
		size=size+1;
	}

	public void deleteAtLoc(int location) {
		if (location == 1) {
			start = start.getLink();
			size--;
			return;
		}
		if (location == size) {
			Node<T> current = start;
			Node<T> temp = start;
			Node<T> next = current.getLink();
			while (next != null) {
				temp = current;
				current = current.getLink();
				next = next.getLink();
			}
			temp.setLink(null);
			size--;
			return;
		}
		Node<T> ptr = start;
		location = location - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == location) {
				Node<T> tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}

	public void deleteByValue(T val) {
		if (start.getData() == val) {
			if (start.getLink() == null) {
				start = null;
			} else {
				start = start.getLink();
			}
			System.out.println("deleted " + val);
			size--;
		} else {
			Node<T> nextptr = start;
			Node<T> prevptr = new Node<T>();
			boolean flag = false;
			for (int i = 1; i <= size; i++) {
				if (val == nextptr.getData()) {
					prevptr.setLink(nextptr.getLink());
					flag = true;
					break;
				}
				prevptr = nextptr;
				nextptr = nextptr.getLink();
			}
			if (flag) {
				size--;
				System.out.println("deleted " + val);
			} else
				System.out.println("Value Not Found");
		}
	}

	public void getAtLoc(int location) {
		Node<T> ptr = start;
		// location = location - 1 ;
		for (int i = 1; i <= size; i++) {
			if (i == location) {
				System.out.println("Value on " + location + " is "
						+ ptr.getData());
				break;
			}
			ptr = ptr.getLink();
		}
	}

	public void reverseLinkedList() {
		Node<T> reversedPart = null;
		Node<T> current = start;
		while (current != null) {
			Node<T> next = current.getLink();
			current.setLink(reversedPart);
			reversedPart = current;
			current = next;
		}
		start = reversedPart;
	}

	public void sortLinkedList() {
		if (size == 0) {
			System.out.println("No elements to sort");
		} else {
			Node<T> currentNode = start;
			Node<T> nextNode = start.getLink();
			for (int i = 0; i < size; i++) {
				while (nextNode != null) {
					if ((Integer) currentNode.getData() > (Integer) nextNode
							.getData()) {
						T temp = currentNode.getData();
						currentNode.setData(nextNode.getData());
						nextNode.setData(temp);
					}

					currentNode = nextNode;
					nextNode = nextNode.getLink();
				}
				currentNode = start;
				nextNode = start.getLink();
			}
		}
	}

	//Function to display LinkedList
	public void display() {
		System.out.print("Singly Linked List = ");
		if (size == 0) {
			System.out.print("Empty\n");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		Node<T> ptr = start;
		System.out.print(start.getData() + "->");
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + "->");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData() + "\n");
	}
}