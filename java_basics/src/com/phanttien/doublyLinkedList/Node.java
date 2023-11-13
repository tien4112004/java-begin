//  package phanttien.doublyLinkedList;

// import javax.swing.text.html.HTMLDocument.Iterator;

public class Node<T> {
    private T data;
    private Node<T> prev;
    private Node<T> next;

    public T getData() {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
