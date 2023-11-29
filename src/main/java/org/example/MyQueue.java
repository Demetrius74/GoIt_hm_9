package org.example;

public class MyQueue {
    private Object[] data;
    private int size = 0;
    private int front = 0;
    private int rear = -1;

    public MyQueue() {
        data = new Object[10];
    }

    public void add(Object value) {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }

    public void clear() {
        data = new Object[10];
        size = 0;
        front = 0;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        } else {
            return data[front];
        }
    }

    public Object poll() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        } else {
            Object value = data[front];
            front = (front + 1) % data.length;
            size--;
            return value;
        }
    }
}
