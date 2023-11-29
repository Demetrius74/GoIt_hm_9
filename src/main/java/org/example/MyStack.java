package org.example;

public class MyStack {
    private Node top = null;
    private int size = 0;

    public void push(Object value) {
        Node newNode = new Node(value, null, top);
        if (top != null) {
            top.setPrev(newNode);
        }
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = top;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        Node prevNode = current.getPrev();
        Node nextNode = current.getNext();

        if (prevNode != null) {
            prevNode.setNext(nextNode);
        } else {
            top = nextNode;
        }
        if (nextNode != null) {
            nextNode.setPrev(prevNode);
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getValue();
    }

    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Object value = top.getValue();
        top = top.getNext();
        if (top != null) {
            top.setPrev(null);
        }
        size--;
        return value;
    }
}
