package org.example;

public class MyArrayList {
    private Object[] data;
    private int size = 0;

    public MyArrayList() {
        data = new Object[10];
    }

    public void add(Object value) {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        data[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < size) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            size--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void clear() {
        data = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < size) {
            return data[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
