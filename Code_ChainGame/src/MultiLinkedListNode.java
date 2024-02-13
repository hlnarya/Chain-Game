import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiLinkedListNode {
    private Element value;
    private List<MultiLinkedListNode> links;

    // Constructor
    public MultiLinkedListNode(Element value) {
        this.value = value;
        this.links = new ArrayList<>();
    }
    public MultiLinkedListNode() {
        this.value = null;
        this.links = new ArrayList<>();
    }

    // Returns the value of the node
    public Element getValue() {
        return value;
    }

    // Sets the value of the node
    public void setValue(Element value) {
        this.value = value;
    }

    // Returns the list of links
    public List<MultiLinkedListNode> getLinks() {
        return links;
    }
    public MultiLinkedListNode getNext() {
        return (links != null && !links.isEmpty()) ? links.get(0) : null;
    }

    // Add a link to another node
    public void addLink(MultiLinkedListNode node) {
        links.add(node);
    }

    // Remove a link to another node
    public void removeLink(MultiLinkedListNode node) {
        links.remove(node);
    }

    // Print the value of the node and recursively print the values of the linked nodes
    public void print() {
        print(this, new HashSet<>());
    }

    private void print(MultiLinkedListNode node, Set<MultiLinkedListNode> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        System.out.print(node.getValue().getElement()+' ');
        visited.add(node);

        for (MultiLinkedListNode linkedNode : node.getLinks()) {
            print(linkedNode, visited);
        }
    }
}
