package JavaCodingExamplePkg;

class NodeDouble<E> {
	E data;
	NodeDouble<E> previous;
	NodeDouble<E> next;
	
	NodeDouble(E data, NodeDouble<E> previous){
		this.data = data;
		this.previous =  previous;
		this.next = null;
	}
}

class DoublyLinkedList<E>{
	private NodeDouble<E> head;
	
	public void addNode(E data) {
		if(head == null) {
			head = new NodeDouble<>(data, null);
			head.previous = null;
			head.next = null;
			return;
		}
		
		NodeDouble<E> temp;
		NodeDouble<E> previous;
		previous = head;
		temp = head;
		while(temp.next!=null) {
			previous = temp;
			temp = temp.next;
		}
		temp.next = new NodeDouble<E>(data, previous);
	}
	
	public void removeNode(E data) {
		NodeDouble<E> temp;
		NodeDouble<E> previous;
		previous = head;
		temp = head;
		
		if(head.data.equals(data)) {
			head = head.next;
			if(head!=null) {
				head.previous = null;
			}
			return;
		}
		do {
			if(temp.data.equals(data)) {
				previous.next = temp.next;
				temp = temp.next;
				if(previous!=null && temp!=null) {
					temp.previous = previous;
				} 
				break;
			}
			previous = temp;
			temp = temp.next;
		} while (temp!=null) ;
	}
	
	public void printList() {
		if(head == null) {
			System.out.println("<Empty doubly linked List>"); return;
		}
		NodeDouble<E> temp;
		temp = head;
		do{
			System.out.print(temp.data + "->");
			temp = temp.next;
		} while(temp!=null && temp.next!=null && temp.data!=null) ;
		if(temp!=null) {
			System.out.print(temp.data);
		}
	}

	public void updateNode(E dataFrom, E dataTo) {
		if(head == null) {
			System.out.println("<Empty doubly linked List>"); return;
		}
		NodeDouble<E> temp;
		temp = head;
		do{
			if(temp.data.equals(dataFrom)) {
				temp.data = dataTo;
				break;
			}
			temp = temp.next;
		} while(temp!=null && temp.next!=null && temp.data!=null) ;
		
	}
}
public class MyDoublyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
		doublyLinkedList.addNode(10);
		doublyLinkedList.addNode(20);
		doublyLinkedList.addNode(30);
		doublyLinkedList.addNode(40);
		doublyLinkedList.addNode(50);
		
		doublyLinkedList.printList();
		
		doublyLinkedList.removeNode(20);
		System.out.println("\n---------Removing 20---------");
		doublyLinkedList.printList();
		
		doublyLinkedList.updateNode(30, 200);
		System.out.println("\n---------Update 30 to 200---------");
		doublyLinkedList.printList();
		
		doublyLinkedList.removeNode(30);
		System.out.println("\n---------Removing 30---------");
		doublyLinkedList.printList();
		
		doublyLinkedList.removeNode(40);
		System.out.println("\n---------Removing 40---------");
		doublyLinkedList.printList();

		doublyLinkedList.removeNode(50);
		System.out.println("\n---------Removing 50---------");
		doublyLinkedList.printList();
		
		doublyLinkedList.removeNode(10);
		System.out.println("\n---------Removing 10---------");
		doublyLinkedList.printList();
		
		
	}
}