package com.coding.problems.heaps;

import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = {getListNode1(), getListNode2(), getListNode3()};

        ListNode result = mergeKSortedLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static ListNode mergeKSortedLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });

        for(ListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }

        ListNode result = null;
        ListNode smallNodeEnd = null;
        while (!queue.isEmpty()) {
            ListNode smallNode = queue.poll();
            if(result == null) {
                result = smallNode;
            } else {
                smallNodeEnd.next = smallNode;
            }
            smallNodeEnd = smallNode;

            if(smallNode.next != null) {
                queue.add(smallNode.next);
            }
        }
        return result;
    }

    private static ListNode getListNode1() {
        ListNode one = new ListNode(1);
        one.next = new ListNode(4);
        one.next.next = new ListNode(5);
        return one;
    }

    private static ListNode getListNode2() {
        ListNode one = new ListNode(1);
        one.next = new ListNode(3);
        one.next.next = new ListNode(4);
        return one;
    }

    private static ListNode getListNode3() {
        ListNode two = new ListNode(2);
        two.next = new ListNode(6);
        return two;
    }
}
