package com.phanttien.BinarySearchTree;

import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
    private int nodeCount = 0;

    private Node<T> root = null;

    @Override
    public boolean isEmpty() {
        return nodeCount == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    // @Override
    // public boolean add(T element) {
    // if (contains(element))
    // return false;
    // root = add(root, element);
    // nodeCount++;
    // return true;
    // }

    @Override
    public boolean add(T element) {
        Node<T> current = root;
        Node<T> parent = null;
        while (current != null) {
            int compare = element.compareTo((T) current.getData());
            parent = current;
            if (compare == 0)
                return false;
            else if (compare > 0)
                current = current.getRight();
            else
                current = current.getLeft();
        }
        current = new Node<T>(element, null, null);

        if (parent == null)
            root = current;
        else if (element.compareTo((T) parent.getData()) > 0)
            parent.setRight(current);
        else
            parent.setLeft(current);

        nodeCount++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        if (!contains(element))
            return false;
        root = remove(root, element);
        nodeCount--;
        return true;
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        switch (type) {
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }

    private Iterator<T> preOrderTraversal() {
        final int expectedCount = nodeCount;
        Stack<Node<T>> stack = new Stack<>();
        stack.add(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount)
                    throw new java.util.ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount)
                    throw new java.util.ConcurrentModificationException();
                Node<T> current = stack.peek();
                stack.pop();

                if (current.getRight() != null)
                    stack.add(current.getRight());
                if (current.getLeft() != null)
                    stack.add(current.getLeft());

                return current.getData();
            }
        };
    }

    // private Iterator<T> preOrderTraversal() {
    // return null;
    // final int expectedCount = nodeCount;
    // Stack<Node<T>> stack = new Stack<>();
    // stack.add(root);

    // return new Iterator<T>() {
    // @Override
    // public boolean hasNext() {
    // if (expectedCount != nodeCount)
    // throw new java.util.ConcurrentModificationException();
    // return root != null && !stack.isEmpty();
    // }

    // @Override
    // public T next() {
    // if (expectedCount != nodeCount)
    // throw new java.util.ConcurrentModificationException();
    // Node<T> current = stack.peek();
    // stack.pop();

    // if (current.getRight() != null)
    // stack.add(current.getRight());
    // if (current.getLeft() != null)
    // stack.add(current.getLeft());

    // return current.getData();
    // }
    // };
    // }

    private Iterator<T> inOrderTraversal() {
        final int expectedCount = nodeCount;
        Stack<Node<T>> stack = new Stack<>();

        // return null;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (nodeCount != expectedCount)
                    throw new java.util.ConcurrentModificationException();

                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (nodeCount != expectedCount)
                    throw new java.util.ConcurrentModificationException();

                Node<T> current = stack.peek();
                stack.pop();

                while (current.getLeft() != null) {
                    stack.push(current.getLeft());
                    current = current.getLeft();
                }

                Node<T> node = stack.pop();
                if (node.getRight() != null)
                    stack.push(node.getRight());
                return node.getData();
            }
        };
    }

    private Iterator<T> postOrderTraversal() {
        return null;
    }

    private Iterator<T> levelOrderTraversal() {
        final int expectedCount = nodeCount;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount)
                    throw new java.util.ConcurrentModificationException();
                return root != null && !queue.isEmpty();
            }

            public T next() {
                Node<T> node = queue.peek();
                queue.remove();

                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
                return (T) node.getData();
            }
        };
    }

    // PRIVATE
    private int height(Node<T> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(Node<T> node, T elem) {
        if (node == null)
            return false;

        if (elem.compareTo((T) node.getData()) == 0)
            return true;

        if (elem.compareTo((T) node.getData()) > 0) {
            return contains(node.getRight(), elem);
        } else {
            return contains(node.getLeft(), elem);
        }
    }

    private Node<T> add(Node<T> node, T elem) {
        if (node == null) {
            node = new Node<T>(elem, null, null);
        } else {
            boolean larger = elem.compareTo((T) node.getData()) > 0;
            if (larger) {
                node.setRight(add(node.getRight(), elem));
            } else {
                node.setLeft(add(node.getLeft(), elem));
            }
        }

        return node;
    }

    private Node<T> remove(Node<T> node, T elem) {
        if (node == null)
            return null;

        int compare = elem.compareTo((T) node.getData());
        if (compare > 0) {
            node.setRight(remove(node.getRight(), elem));
        } else if (compare < 0) {
            node.setLeft(remove(node.getLeft(), elem));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                Node<T> temp = (node.getLeft() != null ? node.getLeft() : node.getRight());
                node.setData(null);
                node = null;
                return temp;
            } else {
                T temp = minRight(node);
                node.setData(temp);
                node.setRight(remove(node.getRight(), temp));
            }
        }
        return node;
    }

    private T minRight(Node<T> node) { // find successor
        while (node.getLeft() != null)
            node = node.getLeft();

        return (T) node.getData();
    }

    private T maxLeft(Node<T> node) { // find predecessor
        while (node.getRight() != null)
            node = node.getRight();

        return (T) node.getData();
    }
}
