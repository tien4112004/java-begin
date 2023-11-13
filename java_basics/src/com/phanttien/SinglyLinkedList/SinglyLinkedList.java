
package com.phanttien.SinglyLinkedList;

import com.phanttien.SinglyLinkedList.SListNode;

public interface SinglyLinkedList<T> extends Iterable<T> {
    void printList();

    void clear();

    int size();

    boolean isEmpty();

    void addFirst(T element);

    void addLast(T element);

    T peekFirst();

    T peekLast();

    SListNode<T> getTailNode();

    T removeFirst();

    T removeLast();

    T remove(SListNode<T> node);

    boolean remove(Object obj);

    T removeAt(int index);

    int indexOf(Object obj);

    boolean contains(Object obj);
}
