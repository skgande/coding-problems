package com.coding.problems.linkedlists;

public class DetectLoopInLinkedList {
    public static void main(String[] args) {
        Node three = new Node(3);
        Node zero = new Node(0);
        Node two = new Node(2);
        Node four = new Node(4);

        three.next = zero;
        zero.next = two;
        two.next = four;
        four.next = zero;

        if(isLoopExists(three)) {
            System.out.println("Loop exists");
        } else {
            System.out.println("No loop");
        }
    }

    private static boolean isLoopExists(Node head) {
        Node slow = head, fast = head;

        while (fast != null & fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return  true;
            }
        }
        return false;
    }
}
