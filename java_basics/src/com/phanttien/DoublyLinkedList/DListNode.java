package com.phanttien.DoublyLinkedList;

// import javax.swing.text.html.HTMLDocument.Iterator;

public class DListNode<T> {
    private T data;
    private DListNode<T> prev;
    private DListNode<T> next;

    public T getData() {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DListNode<T> prev) {
        this.prev = prev;
    }

    public DListNode<T> getNext() {
        return next;
    }

    public void setNext(DListNode<T> next) {
        this.next = next;
    }

    public DListNode(T data, DListNode<T> prev, DListNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
