package com.coding.problems.linkedlists;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode ten = new ListNode(10);
        ListNode twenty = new ListNode(20);
        ListNode thirty = new ListNode(30);
        ListNode forty = new ListNode(40);
        ListNode fifty = new ListNode(50);
        ListNode sixty = new ListNode(60);

        ten.next = twenty;
        twenty.next = thirty;
        thirty.next = forty;
        forty.next = fifty;

        ListNode node1 = ten;
        sixty.next = thirty;
        ListNode node2 = sixty;

        ListNode intersectNode = getIntersectionNode(node1, node2);

        System.out.println("Intersection of two linked lists: " + intersectNode.data);
    }

    private static ListNode getIntersectionNode(ListNode node1, ListNode node2) {
        ListNode ptr1 = node1;
        ListNode ptr2 = node2;

        if(ptr1 == null || ptr2 == null) {
            return null;
        }

        while(ptr1 != ptr2) {
            ptr1 = (ptr1 != null) ? ptr1.next : node2;
            ptr2 = (ptr2 != null) ? ptr2.next : node1;
        }

        return ptr1;
    }
}
