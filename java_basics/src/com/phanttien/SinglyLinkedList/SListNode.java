package com.phanttien.SinglyLinkedList;

class SListNode<T> {
    private T data;
    private SListNode<T> next;

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

    public SListNode<T> getNext() {
        return next;
    }

    public SListNode<T> setNext(SListNode<T> next) {
        this.next = next;
        return this;
    }

    public SListNode(T data, SListNode<T> next) {
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
