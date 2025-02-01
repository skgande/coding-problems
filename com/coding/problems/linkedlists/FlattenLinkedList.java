package com.coding.problems.linkedlists;

class MultiNode {
    int data;
    MultiNode next, child;

    MultiNode(int data) {
        this.data = data;
    }
}
public class FlattenLinkedList {
    public static void main(String[] args) {
        MultiNode one = new MultiNode(1);
        MultiNode two = new MultiNode(2);
        MultiNode three = new MultiNode(3);
        MultiNode four = new MultiNode(4);
        MultiNode five = new MultiNode(5);
        MultiNode six = new MultiNode(6);
        MultiNode seven = new MultiNode(7);
        MultiNode eight = new MultiNode(8);
        MultiNode nine = new MultiNode(9);
        MultiNode ten = new MultiNode(10);
        MultiNode eleven = new MultiNode(11);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        two.child = six;
        six.next = seven;
        seven.child = ten;

        four.child = eight;
        eight.child = eleven;
        eight.next = nine;

        MultiNode head = one;

        head = flattenList(head);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static MultiNode flattenList(MultiNode head) {
        if(head == null) {
            return head;
        }

        MultiNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        MultiNode curr = head;
        while (curr != null) {
            if(curr.child != null) {
                tail.next = curr.child;

                MultiNode temp = curr.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                tail = temp;

                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }
}
