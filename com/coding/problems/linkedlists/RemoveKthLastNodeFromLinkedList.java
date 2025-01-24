package com.coding.problems.linkedlists;

public class RemoveKthLastNodeFromLinkedList {
    public static void main(String[] args) {
        Node one = new Node(1);
        one.next = new Node(2);
        one.next.next = new Node(3);
        one.next.next.next = new Node(4);
        one.next.next.next.next = new Node(5);
        Node head = one;

        int length = getLength(head);
        int k = 2;
        int nodeFromBegining = length - k + 1;

        head = deleteKthNodeFromEnd(head, nodeFromBegining);
        printList(head);
    }

    private static Node deleteKthNodeFromEnd(Node head, int nodeFromBegining) {
        Node prev = null, curr = head;
        for(int i = 1; i < nodeFromBegining; i++) {
            prev = curr;
            curr = curr.next;
        }

        if(prev == null) {
            head = head.next;
        } else {
            prev.next = curr.next;
        }
        return head;
    }

    private static int getLength(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
