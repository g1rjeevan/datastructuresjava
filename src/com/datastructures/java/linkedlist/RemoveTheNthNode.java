package com.datastructures.java.linkedlist;

public class RemoveTheNthNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dupHead = head;
        ListNode currentHead = head;
        int len = 0;
        ListNode listNode[] = new ListNode[30];
        while (currentHead.next != null) {
            listNode[len] = new ListNode(currentHead.val);
            currentHead = currentHead.next;
            len++;
        }
        listNode[len] = new ListNode(currentHead.val);
        len++;
        ListNode newNode = null;
        while (len > 0) {
            if (n != 1) {
                currentHead = newNode;
                newNode = new ListNode(listNode[len - 1].val);
                newNode.next = currentHead;
            }
            n--;
            len--;
        }

        return newNode;
    }
}
