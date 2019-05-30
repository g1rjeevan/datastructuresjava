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
		linkedList.head = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);

		linkedList.head.next = node_2;
		node_2.next = node_3;
		node_3.next = node_4;
		linkedList.printLinkedList();

	}

	void printLinkedList() {
		Node node = head;
		while (node != null) {
			System.out.println("Node data: " + node.data);
			node = node.next;
		}
	}

}
