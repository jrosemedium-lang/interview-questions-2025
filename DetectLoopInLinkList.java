package JavaCodingExamplePkg;

public class DetectLoopInLinkList {
	// Function to create a linked list with a loop for testing
	
	// Node class to represent each element in the list
    static class Node {
        int data;
        Node next;
        
        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Head of the list
    Node head;
    
    // Function to detect loop in the linked list
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;             // move slow pointer by 1 step
            fast = fast.next.next;        // move fast pointer by 2 steps
            
            if (slow == fast) {           // If they meet, loop exists
                return true;
            }
        }
        
        return false;                      // No loop
    }
    
    
    public static void main(String[] args) {
    	DetectLoopInLinkList list = new DetectLoopInLinkList();
        
        // Create nodes
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        
        // Link nodes
        list.head.next = second;
        second.next = third;
        third.next = fourth;
        
        // Creating a loop: third node points back to second
        fourth.next = second;
        
        // Check if the linked list has a loop
        if (list.hasLoop()) {
            System.out.println("Loop detected!");
        } else {
            System.out.println("No loop detected.");
        }
    }
}
