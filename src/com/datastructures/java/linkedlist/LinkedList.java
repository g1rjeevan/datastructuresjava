package com.datastructures.java.linkedlist;

public class LinkedList extends Object {

    Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(2);
        linkedList.push(23);
        linkedList.insertAtEnd(32);

        linkedList.insertSpecific(getSpecificNode(1, linkedList), 11);
        linkedList.insertSpecific(getSpecificNode(4, linkedList), 11);

        linkedList.printLinkedList();

    }

    void printLinkedList() {
        Node node = head;
        while (node != null) {
            System.out.println("Node data: " + node.data);
            node = node.next;
        }
    }

    void push(int key) {
        Node node = new Node(key);
        node.next = head;
        head = node;
    }

    static Node getSpecificNode(int value, LinkedList linkedList) {
        Node prevNode = linkedList.head;
        while (value - 1 != 0) {
            prevNode = prevNode.next;
            value--;
        }
        return prevNode;
    }

    void insertSpecific(Node previousNode, int key) {

        if (previousNode == null) {
            push(key);
        }
        Node currentNode = new Node(key);
        currentNode.next = previousNode.next;
        previousNode.next = currentNode;
    }

    void insertAtEnd(int key) {
        if (head == null)
            push(key);
        Node tempHead = head;
        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }
        tempHead.next = new Node(key);
    }

    void deleteSpecific(int key) {
        Node currentHead = head;
        Node tempPrev = null;
        if (currentHead != null && currentHead.data == key) {
            head = currentHead.next;
            return;
        }
        while (currentHead.next != null && currentHead.data != key) {
            tempPrev = currentHead;
            currentHead = currentHead.next;
        }
        if (currentHead == null) {
            return;
        }
        tempPrev.next = currentHead.next;
    }

}
