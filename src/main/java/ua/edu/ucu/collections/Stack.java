package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList generalStack;

    public Stack() {
        generalStack = new ImmutableLinkedList();
    }
    public Object peek() {
        return generalStack.getLast();
    }

    public Object pop() {
        Object result = generalStack.getLast();
        generalStack = generalStack.removeLast();
        return result;
    }

    public void push(Object e) {
        if (generalStack.getLast() == null) {
            generalStack = generalStack.set(0, e);
        }
        else {
            generalStack = generalStack.addLast(e);
        }
    }
}
