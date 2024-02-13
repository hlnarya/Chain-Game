import java.util.ArrayList;
import java.util.List;

import enigma.console.Console;

public class MultiLinkedList {
    private MultiLinkedListNode head;

    // Constructor
    public MultiLinkedList(MultiLinkedListNode head) {
        this.head = head;
    }
    public MultiLinkedList() {
    	this.head = null;
    }

    // Returns the list of heads
    public MultiLinkedListNode getHead() {
        return head;
    }
    public void setHead(MultiLinkedListNode head) {
    	this.head = head;
    }

    // Combine multiple single linked lists and link the head of each with the next single linked list
    
    public void addAndLink(SingleLinkedList list) {
        if (list == null || list.getHead() == null) {
            return;
        }
        Node chain = list.getHead();
        MultiLinkedListNode temp = new MultiLinkedListNode(chain.getData());
        if(head==null) {
        	this.head = temp;
        }else {
        	head.addLink(temp);
        }
        while(chain.getLink()!=null) {
        	chain = chain.getLink();
        	MultiLinkedListNode temp2 = new MultiLinkedListNode(chain.getData());
        	temp.addLink(temp2);
        	temp = temp2;
        }
        
    }
public void tableDisplay(Console console) {
        // Iterate over each linked list
		console.getTextWindow().setCursorPosition(35,5);
		System.out.print(head.getValue().getElement()+"+");
		for(int chainID = 0; chainID < head.getLinks().size(); chainID++) {
			
            MultiLinkedListNode temp = head.getLinks().get(chainID);
            System.out.print(temp.getValue().getElement() + "+");
            while (temp.getNext() != null) {
            	temp = temp.getNext();
            	if(temp.getNext() != null)
            		System.out.print(temp.getValue().getElement() + "+");
            	else
            		System.out.print(temp.getValue().getElement());
                
            }
            if(chainID < head.getLinks().size()-1) {
            	console.getTextWindow().setCursorPosition(35,2*chainID+6);
                System.out.print("+");
                console.getTextWindow().setCursorPosition(35,2*chainID+7);
            }
        }
    }

    // Display the content of the multi linked list
   
}