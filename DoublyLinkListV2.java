package JavaCodingExamplePkg;

class NodeDoubleV2<E> {
    E data;
    NodeDoubleV2<E> previous;
    NodeDoubleV2<E> next;

    NodeDoubleV2(E data, NodeDoubleV2<E> previous) {
        this.data = data;
        this.previous = previous;
        this.next = null;
    }
}

class DoublyLinkedListV2<E> {
    private NodeDoubleV2<E> head;

    public void addNode(E data) {
        if (head == null) {
            head = new NodeDoubleV2<>(data, null);
            return;
        }

        NodeDoubleV2<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        NodeDoubleV2<E> newNode = new NodeDoubleV2<>(data, temp);
        temp.next = newNode;
    }

    public void removeNode(E data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
            if (head != null) head.previous = null;
            return;
        }

        NodeDoubleV2<E> temp = head.next;
        while (temp != null) {
            if (temp.data.equals(data)) {
                if (temp.previous != null)
                    temp.previous.next = temp.next;
                if (temp.next != null)
                    temp.next.previous = temp.previous;
                return;
            }
            temp = temp.next;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("<Empty doubly linked list>");
            return;
        }

        NodeDoubleV2<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void updateNode(E dataFrom, E dataTo) {
    	NodeDoubleV2<E> temp = head;
        while (temp != null) {
            if (temp.data.equals(dataFrom)) {
                temp.data = dataTo;
                return;
            }
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
    	 DoublyLinkedListV2<Integer> doublyLinkedList = new DoublyLinkedListV2<>();

         doublyLinkedList.addNode(10);
         doublyLinkedList.addNode(20);
         doublyLinkedList.addNode(30);
         doublyLinkedList.addNode(40);
         doublyLinkedList.addNode(50);

         doublyLinkedList.printList();  // 10 -> 20 -> 30 -> 40 -> 50

         System.out.println("---------Removing 20---------");
         doublyLinkedList.removeNode(20);
         doublyLinkedList.printList();  // 10 -> 30 -> 40 -> 50

         System.out.println("---------Update 30 to 200---------");
         doublyLinkedList.updateNode(30, 200);
         doublyLinkedList.printList();  // 10 -> 200 -> 40 -> 50

         System.out.println("---------Removing 30---------");
         doublyLinkedList.removeNode(30);  // 30 was already updated, so no effect
         doublyLinkedList.printList();  // 10 -> 200 -> 40 -> 50

         System.out.println("---------Removing 40---------");
         doublyLinkedList.removeNode(40);
         doublyLinkedList.printList();  // 10 -> 200 -> 50

         System.out.println("---------Removing 50---------");
         doublyLinkedList.removeNode(50);
         doublyLinkedList.printList();  // 10 -> 200

         System.out.println("---------Removing 10---------");
         doublyLinkedList.removeNode(10);
         doublyLinkedList.printList();  // 200
	}
}
