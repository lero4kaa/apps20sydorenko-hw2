package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList generalQueue;

    public Queue() {
        generalQueue = new ImmutableLinkedList();

    }
    public Object peek() {
        return generalQueue.getFirst();
    }

    public Object dequeue() {
        Object result = generalQueue.getFirst();
        generalQueue = generalQueue.removeFirst();
        return result;
    }

    public void enqueue(Object e) {
        if (generalQueue.getFirst() == null) {
            generalQueue = generalQueue.set(0, e);
        }
        else {
            generalQueue = generalQueue.addLast(e);
        }
    }

}
