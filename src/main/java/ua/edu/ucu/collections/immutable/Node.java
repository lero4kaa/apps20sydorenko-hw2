package ua.edu.ucu.collections.immutable;

public class Node {
    public Object value;
    Node next;
    public Node(Object v) {
        value = v;
    }
    public Node() {
        value = null;
    }

    public void setNext(Node newNode) {
        next = newNode;
    }
}
