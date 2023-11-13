package com.phanttien.DoublyLinkedList;

public interface DoublyLinkedList<T> extends Iterable<T> {
    void clear();

    int size();

    boolean empty();

    void add(T element);

    void addFirst(T element);

    void addLast(T element);

    T peekFirst();

    T peekLast();

    DListNode<T> getTailNode();

    T removeFirst();

    T removeLast();

    T remove(DListNode<T> node);

    boolean remove(Object obj);

    T removeAt(int index);

    int indexOf(Object obj);

    boolean contains(Object obj);

    void printList();
}
