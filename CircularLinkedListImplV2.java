package JavaCodingExamplePkg;

class NodeCircularV2<E> {
    E data;
    NodeCircular<E> next;

    NodeCircularV2(E data) {
        this.data = data;
    }
}

class MyCircularLinkedListV2<E> {
    private NodeCircular<E> head = null;
    private NodeCircular<E> tail = null;

    public void addNode(E data) {
        NodeCircular<E> newNode = new NodeCircular<>(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;  // circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;  // maintain circularity
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("<empty linked list>");
            return;
        }

        NodeCircular<E> temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public void removeData(E data) {
        if (head == null) return;

        NodeCircular<E> current = head;
        NodeCircular<E> previous = tail;
        boolean found = false;

        do {
            if (current.data.equals(data)) {
                found = true;

                // If list has only one node
                if (current == head && current == tail) {
                    head = tail = null;
                }
                // If removing head
                else if (current == head) {
                    head = head.next;
                    tail.next = head;
                }
                // If removing tail
                else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                }
                // Removing middle node
                else {
                    previous.next = current.next;
                }
                break;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println(data + " not found in the list.");
        }
    }

    public void updateData(E dataFrom, E dataTo) {
        if (head == null) {
            System.out.println("<empty linked list, can't update>");
            return;
        }

        NodeCircular<E> temp = head;
        do {
            if (temp.data.equals(dataFrom)) {
                temp.data = dataTo;
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println(dataFrom + " not found in the list.");
    }
}

public class CircularLinkedListImplV2 {
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
