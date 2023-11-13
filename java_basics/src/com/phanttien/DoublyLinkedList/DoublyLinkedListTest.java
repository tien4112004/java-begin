package com.phanttien.DoublyLinkedList;

import java.util.Scanner;
import java.io.File;

public class DoublyLinkedListTest {
    public static void main(String args[]) {
        long start = System.nanoTime();

        Scanner s;
        try {
            s = new Scanner(new File("in"));
        } catch (Exception e) {
            System.out.println("File not found! Using input from console.");
            s = new Scanner(System.in);
        }

        int n = s.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        // Create linked list from array a[]
        DoublyLinkedList<Integer> list = new DefaultDoublyLinkedList<Integer>();
        for (int i = 0; i < n / 2; i++) {
            list.addFirst(a[i]);
        }
        for (int i = n / 2; i < n; i++) {
            list.addLast(a[i]);
        }
        System.out.println("list.peekFirst() = " + list.peekFirst() + "\n");
        System.out.println("list.peekLast() = " + list.peekLast() + "\n");

        System.out.println(list.toString());

        System.out.println();
        list.removeFirst();
        list.printList();

        DListNode<Integer> lastNode = list.getTailNode();
        System.out.println();
        // list.removeLast();
        list.remove(lastNode);
        list.printList();

        System.out.println();
        list.removeAt(2);
        list.printList();

        System.out.println();
        list.remove(4);
        list.printList();

        System.out.println(
                "\nlist.indexOf(10) = " + list.indexOf(10));
        System.out.println(
                "\nlist.contains(10) = " + list.contains(10));

        s.close();

        long end = System.nanoTime();
        System.out.println("\nTime elapsed: " + (end - start) / 1000000 + "ms");
    }
}
