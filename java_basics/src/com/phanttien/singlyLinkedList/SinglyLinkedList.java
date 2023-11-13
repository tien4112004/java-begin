// package com.phanttien.singlyLinkedList;

public interface SinglyLinkedList<T> extends Iterable<T> {
    void printList();

    void clear();

    int size();

    boolean isEmpty();

    void addFirst(T element);

    void addLast(T element);

    T peekFirst();

    T peekLast();

    Node<T> getTailNode();

    T removeFirst();

    T removeLast();

    T remove(Node<T> node);

    boolean remove(Object obj);

    T removeAt(int index);

    int indexOf(Object obj);

    boolean contains(Object obj);
}
