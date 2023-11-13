// package com.phanttien.singlyLinkedList;

class Node<T> {
    private T data;
    private Node<T> next;

    public T getData() {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        return data;
    }

    public void setData(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

    public Node(T data, Node<T> next) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        return data.toString();
    }

}
