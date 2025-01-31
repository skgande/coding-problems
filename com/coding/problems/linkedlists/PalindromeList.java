package com.coding.problems.linkedlists;

public class PalindromeList {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(2);
        Node five = new Node(1);

        one.next = two;
        two.next = three;
       three.next = four;
       four.next = five;

        Node head = one;
        if(head == null || head.next == null) {
            System.out.println("Palindrome list");
        } else {
            Node mid = getMid(one);
            Node midNode = getReverseNode(mid);
            boolean isPalindrome = isIdentical(head, midNode);
            if(isPalindrome) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not a palindrome");
            }
        }
    }

    private static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    private static Node getReverseNode(Node head) {
        Node prev = null, next, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static boolean isIdentical(Node node1, Node node2) {
        while (node1 != null && node2 != null) {
            if(node1.data != node2.data){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
