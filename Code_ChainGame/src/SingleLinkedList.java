public class SingleLinkedList {
    private Node head;
    public SingleLinkedList() {
        this.head = null;
    }
    public void add(Element data ){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.getLink() != null){
                temp = temp.getLink();
            }
            temp.setLink(newNode);
        }
    }
    public Node getHead() {
        return head;
    }
    public int size (){
        if(head == null)
            return 0;
        else{
            Node temp = head;
            int count =0;
            while(temp != null ){
                count++;
                temp = temp.getLink();
            }
            return count;
        }
    }
    public void display(){
        if(head == null){
        }else{
            Node temp = head;
            System.out.print(temp.getElement() + " ");
            while(temp.getLink() != null){
            	temp = temp.getLink();
                System.out.print(temp.getElement() + " ");
            }
        }
    }
    /*
	public void dotTheElement(Element[][] element) {
		Node temp = this.head;
		element[temp.getData().getHeight()][temp.getData().getWidth()].setElement('.');
		element[temp.getData().getHeight()][temp.getData().getWidth()].setChained(-1);
		while(temp.getLink()!=null) {
			temp = temp.getLink();
			element[temp.getData().getHeight()][temp.getData().getWidth()].setElement('.');
			element[temp.getData().getHeight()][temp.getData().getWidth()].setChained(-1);
		}
		
	}
	*/
}
