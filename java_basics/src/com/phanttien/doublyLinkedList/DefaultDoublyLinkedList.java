// package phanttien.doublyLinkedList;

import java.util.Iterator;

public class DefaultDoublyLinkedList<T> implements DoublyLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.getNext();
            current.setPrev(null);
            current.setData(null);
            current.setNext(null);
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
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public void addFirst(T element) {
        Node<T> new_node = new Node<T>(element, null, head);
        if (empty())
            tail = new_node;
        if (head != null)
            head.setPrev(new_node);
        head = new_node;
        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> new_node = new Node<T>(element, tail, null);
        if (empty())
            head = new_node;
        if (tail != null)
            tail.setNext(new_node);
        tail = new_node;
        size++;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public T peekFirst() {
        if (empty())
            throw new RuntimeException("Empty list.");
        return head.getData();
    }

    @Override
    public T peekLast() {
        if (empty())
            throw new RuntimeException("Empty list.");
        return tail.getData();
    }

    @Override
    public Node<T> getTailNode() {
        if (empty())
            throw new RuntimeException("Empty list.");
        return tail;
    }

    @Override
    public T removeFirst() {
        if (empty())
            throw new IllegalArgumentException("Empty list.");
        T data = head.getData();
        Node<T> node = head.getNext();
        if (node != null)
            node.setPrev(null);
        head.setData(null);
        head.setNext(null);
        head = node;
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (empty())
            throw new IllegalArgumentException("Empty list.");
        T data = tail.getData();
        Node<T> node = tail.getPrev();
        tail.setData(null);
        tail.setPrev(null);
        if (node != null)
            node.setNext(null);
        tail = node;
        size--;
        return data;
    }

    @Override
    public T remove(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null.");
        }
        if (node.getPrev() == null)
            return removeFirst();
        if (node.getNext() == null)
            return removeLast();

        T data = node.getData();
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        node.setData(null);
        node.setPrev(null);
        node.setNext(null);
        size--;
        return data;
    }

    @Override
    public boolean remove(Object obj) {
        Node<T> current = head;

        if (obj == null) {
            while (current != null) {
                if (current.getData() == null) {
                    remove(current);
                    return true;
                }
                current = current.getNext();
            }
        } else {
            while (current != null) {
                if (obj.equals(current.getData())) {
                    remove(current);
                    return true;
                }

                current = current.getNext();
            }
        }

        return false;
    }

    @Override
    public T removeAt(int index) {
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                T data = current.getData();
                remove(current);
                return data;
            }
            i++;
            current = current.getNext();
        }

        throw new IllegalArgumentException("Index not found.");
    }
    

    @Override
    public int indexOf(Object obj) {
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            if (current.getData().equals(obj)) {
                return i;
            }
            i++;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(obj)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
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
        if (empty())
            return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[ ");

            Node<T> current = head;

            while (current != null) {
                sb.append(current.getData());
                if (current.getNext() != null)
                    sb.append(", ");
                current = current.getNext();
            }
            sb.append(" ]");
            return sb.toString();
        }
    }

    @Override
    public void printList() {
        System.out.println(toString());
    }
}
