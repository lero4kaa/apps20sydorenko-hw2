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

    @Override
    public ImmutableLinkedList remove(int index) {
        if (0 > index || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
        Object[] resultArray = new Object[size-1];
        System.arraycopy(generalArray, 0, resultArray, 0, index);
        System.arraycopy(generalArray, index+1, resultArray, index, size-1-index);
        return new ImmutableLinkedList(resultArray);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        Object[] resultArray = new Object[size];
        System.arraycopy(generalArray, 0, resultArray, 0, index);
        resultArray[index] = e;
        System.arraycopy(generalArray, index+1, resultArray, index+1, size-index-1);
        return new ImmutableLinkedList(resultArray);
    }

    @Override
    public int indexOf(Object e) {
        Node curNode = head;
        for (int i = 0; i < size; i ++) {
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
        Node curNode = head;
        for (int i = 0; i < size; i++) {
            resultArray[i] = curNode.value;
            curNode = curNode.next;
        }
        return resultArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return head.value;
    }

    public Object getLast() {
        return tail.value;
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size-1);
    }
}
