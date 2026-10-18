package JavaCodingExamplePkg;

class Node<E> {
	E data;
	Node<E> next;

	Node(E data) {
		this.data = data;
		this.next = null;
	}
}

class MyLinkedList<E> {
	private Node<E> head;

	public void addNode(E data) {
		if (head == null) {
			head = new Node<>(data);
			return;
		}

		Node<E> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node<>(data);
	}

	public void printList() {
		if (head == null) {
			System.out.println("<empty linked list>");
		}
		Node<E> temp = head;
		while (temp != null && temp.next != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		if (temp != null) {
			System.out.print(temp.data);
		}
	}

	public void removeData(String data) {
		if (head.data.equals(data)) {
			head = head.next;
			return;
		}
		Node<E> previous = head;
		Node<E> current = head;
		while (current.next != null) {
			previous = current;
			current = current.next;
			if (current.data.equals(data)) {
				previous.next = current.next;
				break;
			}
		}
	}

	public void updateData(E dataFrom, E dataTo) {
		if (head == null) {
			System.out.println("<empty linked list, can't update>");
		}
		Node<E> temp = head;
		while (temp != null && temp.next != null) {
			if (temp.data.equals(dataFrom)) {
				temp.data = dataTo;
				break;
			}
			temp = temp.next;
		}

	}
}

public class MySinglyLinkedListExample {
	public static void main(String[] args) {
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		myLinkedList.addNode("1");
		myLinkedList.addNode("2");
		myLinkedList.addNode("3");
		myLinkedList.addNode("4");
		myLinkedList.addNode("5");
		System.out.println("----------after insert-------------");
		myLinkedList.printList();

		myLinkedList.removeData("2");
		System.out.println("\n----------after remove-------------");
		myLinkedList.printList();

		myLinkedList.removeData("3");
		System.out.println("\n----------after remove-------------");
		myLinkedList.printList();

		myLinkedList.updateData("4", "400");
		System.out.println("\n----------after update-------------");
		myLinkedList.printList();

		myLinkedList.removeData("4");
		System.out.println("\n----------after remove-------------");
		myLinkedList.printList();

		myLinkedList.removeData("5");
		System.out.println("\n----------after remove-------------");
		myLinkedList.printList();

		myLinkedList.removeData("1");
		System.out.println("\n----------after remove-------------");
		myLinkedList.printList();
	}
}
