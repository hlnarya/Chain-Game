public class Node {
    private Node link;
    private Element element;

    public Node ( Element dataToAdd){
        this.element = dataToAdd;
        this.link = null;
    }
    public Element getData() {
        return this.element;
    }
    public char getElement() {
        return this.element.getElement();
    }
    public void setData(Element data) {
    	this.element = data;
    }
    public Node getLink() {
        return this.link;
    }
    public void setLink(Node link) {
        this.link = link;
    }
}
