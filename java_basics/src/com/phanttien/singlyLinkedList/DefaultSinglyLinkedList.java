// package com.phanttien.singlyLinkedList; 

// import java.nio.ReadOnlyBufferException;
import java.util.Iterator;

// import javax.management.RuntimeErrorException;

public class DefaultSinglyLinkedList<T> implements SinglyLinkedList<T> {
    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.getNext();

            current.setNext(null);
            current.setData(null);
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void addFirst(T element) {
        if (element == null)
            throw new IllegalArgumentException("Data cannot be null");
        Node<T> new_node = new Node<T>(element, head);

        if (isEmpty()) {
            tail = new_node;
        } else {
            head.setNext(new_node);
        }
        head = new_node;
        size++;
    }

    @Override
    public void addLast(T element) {
        if (element == null)
            throw new IllegalArgumentException("Data cannot be null");
        Node<T> new_node = new Node<T>(element, null);

        if (isEmpty()) {
            head = new_node;
        } else {
            tail.setNext(new_node);
        }
        tail = new_node;
        size++;
    }

    @Override
    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list!");
        return head.getData();
    }

    @Override
    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list!");
        return tail.getData();
    }

    @Override
    public Node<T> getTailNode() {
        return tail;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list!");
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty())
            tail = null;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list!");
        T data = tail.getData();
        Node<T> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
        if (isEmpty())
            head = null;
        return data;
    }

    @Override
    public T remove(Node<T> node) {
        if (node == null)
            throw new IllegalArgumentException("Node cannot be null");
        if (node.getNext() == null)
            return removeLast();
        T data = node.getData();
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
        size--;
        return data;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException("Object cannot be null");
        Node<T> current = head;
        while (current != null) {
            if (current.equals(obj)) {
                remove(current);
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index cannot be negative or greater than size");
        int i = 0;
        Node<T> current = head;
        while (current != null) {
            if (i == index) {
                remove(current);
                return current.getData();
            }
            i++;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public int indexOf(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException("Object cannot be null");
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.equals(obj)) {
                return index;
            }
            index++;
            current = current.getNext();
        }

        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.getNext() != null;
            }

            @Override
            public T next() {
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[ ");

            Node<T> current = head;
            while (current != null) {
                sb.append(current.getData());
                if (current.getNext() != null) {
                    sb.append(", ");
                }
                current = current.getNext();
            }
            sb.append(" ]");

            return sb.toString();
        }
    }

    public void printList() {
        System.out.println(toString());
        return;
    }
}