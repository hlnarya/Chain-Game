
public class DoublyLinkedList {
	DoublyLinkedListNode head;

    // Method to insert a new Node
    public void addHighScore(String name, int score) {
    	DoublyLinkedListNode newNode = new DoublyLinkedListNode(name, score);

        if (head == null) {
            head = newNode;
        } else {
        	DoublyLinkedListNode current = head;
        	DoublyLinkedListNode previous = null;
            
            // Finding the correct spot to insert the new node
            while (current != null && current.score > score) {
                previous = current;
                current = current.next;
            }
            
            if (current == head) {
                newNode.next = current;
                current.prev = newNode;
                head = newNode;
            } else if (current == null) {
                previous.next = newNode;
                newNode.prev = previous;
            } else {
                previous.next = newNode;
                newNode.prev = previous;
                newNode.next = current;
                current.prev = newNode;
            }
        }
    }

    // Method to display the high scores
    public void display() {
    	DoublyLinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + "\t" + temp.score);
            temp = temp.next;
        }
    }
}
