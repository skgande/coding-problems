package com.coding.problems.linkedlists;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = getLinkedList();
        printLinkedList(head);
        head = reverseLinkedList(head);
        printLinkedList(head);
    }

    private static Node reverseLinkedList(Node head) {
        Node curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static Node getLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        return head;
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
