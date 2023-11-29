package org.example;

public class MyLinkedList {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public void add(Object value) {
        Node newNode = new Node(value, this.last, null);
        if (this.last != null) {
            this.last.next = newNode;
        } else {
            this.first = newNode;
        }
        this.last = newNode;
        size++;
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node node = this.getNode(index);
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            this.first = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            this.last = prev;
        }
        this.size--;
    }

    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        Node node = this.getNode(index);
        return node.value;
    }

    private Node getNode(int index) {
        Node node = this.first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}