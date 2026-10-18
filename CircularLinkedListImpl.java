package JavaCodingExamplePkg;


class NodeCircular<E> {
	E data;
	NodeCircular<E> next;

	NodeCircular(E data) {
		this.data = data;
		this.next = null;
	}
}

class MyCircularLinkedList<E> {
	private NodeCircular<E> head;
	private NodeCircular<E> last;

	public void addNode(E data) {
		if (head == null) {
			head = new NodeCircular<>(data);
			return;
		}

		NodeCircular<E> temp = head;
		while (temp.next != null && last!=temp) {
			temp = temp.next;
		}
		temp.next = new NodeCircular<>(data);
		temp = temp.next;
		last = temp;//maintain a last pointer to avoid infinite loop
		temp.next = head;
	}

	public void printList() {
		if (head == null) {
			System.out.println("<empty linked list>");
		}
		NodeCircular<E> temp = head;
		while (temp != null && temp.next != null && temp!=last) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		if (temp != null) {
			System.out.print(temp.data);
		}
	}

	public void removeData(E data) {
		if (head.data.equals(data)) {
			head = head.next;
			return;
		}
		

		
		NodeCircular<E> previous = head;
		NodeCircular<E> current = head;
		while (current.next != null) {
			previous = current;
			current = current.next;
			if(last.data.equals(data) && current.data.equals(data)) {
				previous.next = head;
				last = previous;
				break;
			}
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
		NodeCircular<E> temp = head;
		while (temp != null && temp.next != null) {
			if (temp.data.equals(dataFrom)) {
				temp.data = dataTo;
				break;
			}
			temp = temp.next;
		}

	}
}
public class CircularLinkedListImpl {
	public static void main(String[] args) {
		MyCircularLinkedList<Integer> myCircularList = new MyCircularLinkedList<>();
		myCircularList.addNode(10);
		myCircularList.addNode(20);
		myCircularList.addNode(30);
		myCircularList.addNode(40);
		myCircularList.addNode(50);
		

		myCircularList.printList();
		System.out.println("\n-------Removing 20-------");
		myCircularList.removeData(20);
		myCircularList.printList();
		
		System.out.println("\n-------Removing 10--------");
		myCircularList.removeData(10);
		myCircularList.printList();
		
		System.out.println("\n-------Removing 50--------");
		myCircularList.removeData(50);
		myCircularList.printList();
		
		System.out.println("\n-------Update 40 to 500--------");
		myCircularList.updateData(40, 500);
		myCircularList.printList();
	}
}
