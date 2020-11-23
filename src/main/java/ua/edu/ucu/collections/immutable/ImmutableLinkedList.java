package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int size = 0;
    private Object[] generalArray;

    public ImmutableLinkedList() {
        head = new Node();
        tail = head;
    }

    public ImmutableLinkedList(Object[] values) {
        generalArray = values.clone();
        head = new Node(values[0]);
        size += 1;
        Node curNode = head;
        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            curNode.setNext(newNode);
            curNode = newNode;
            size += 1;
        }
        tail = curNode;
    }

    public ImmutableLinkedList(int s) {
        size = s;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        Object[] temp = {e};
        return addAll(size, temp);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        Object[] temp = {e};
        return addAll(index, temp);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {

        return addAll(size, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (0 > index || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
        Object[] resultArray = new Object[size + c.length];
        System.arraycopy(generalArray, 0, resultArray, 0, index);
        System.arraycopy(c, 0, resultArray, index, c.length);
        System.arraycopy(generalArray, index, resultArray, index + c.length, size - index);
        return new ImmutableLinkedList(resultArray);
    }

    @Override
    public Object get(int index) {
        if (0 > index || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.value;
    }

    public Node getNode(int index) {
        if (0 > index || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (0 > index || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
        Node prevNode = getNode(index-1);
        prevNode.setNext(prevNode.next.next);
        return new ImmutableLinkedList(size-1);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        Node curNode = getNode(index);
        curNode.value = e;
        return new ImmutableLinkedList(size);
    }

    @Override
    public int indexOf(Object e) {
        Node curNode = head;
        for (int i = 0; i < size+1; i ++) {
            if (curNode.value == e) {
                return i;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] resultArray = new Object[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = getNode(i).value;
        }
        return resultArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Node prevHead = head;
        head = new Node(e);
        head.setNext(prevHead);
        return new ImmutableLinkedList(size+1);
    }

    public ImmutableLinkedList addlast(Object e) {
        tail.setNext(new Node(e));
        tail = tail.next;
        return new ImmutableLinkedList(size+1);
    }

    public Object getFirst() {
        return head.value;
    }

    public Object getLast() {
        return tail.value;
    }

//    public ImmutableLinkedList removeFirst() {
//        head = head.next;
//        return new ImmutableArrayList(head, tail, ;
//    }


}
