package com.datastructures.java.linkedlist;

public class CircularLinkedList {
	static class Node {
		int data;
		Node next;
	};

	static Node addToEmpty(Node last, int data) {
		// This function is only for empty list
		if (last != null)
			return last;

		// Creating a node dynamically.
		Node temp = new Node();

		// Assigning the data.
		temp.data = data;
		last = temp;

		// Creating the link.
		last.next = last;

		return last;
	}

	static Node addBegin(Node last, int data) {
		if (last == null)
			return addToEmpty(last, data);

		Node temp = new Node();

		temp.data = data;
		temp.next = last.next;
		last.next = temp;

		return last;
	}

	static Node addEnd(Node last, int data) {
		if (last == null)
			return addToEmpty(last, data);

		Node temp = new Node();

		temp.data = data;
		temp.next = last.next;
		last.next = temp;
		last = temp;

		return last;
	}

	static Node addAfter(Node last, int data, int item) {
		if (last == null)
			return null;

		Node temp, p;
		p = last.next;
		do {
			if (p.data == item) {
				temp = new Node();
				temp.data = data;
				temp.next = p.next;
				p.next = temp;

				if (p == last)
					last = temp;
				return last;
			}
			p = p.next;
		} while (p != last.next);

		System.out.println(item + " not present in the list.");
		return last;
//		I am a most dynamic application programmer with various knowledge of different programming language.
//		Who always ready to upgrade my skills to provide better solutions for the software product through my
//		analytical analysis and logical thinking.
//		I worked various number of project where it ranges from android app dev from start to deployment in play store,
//		Web Application dev from end-to-end and backend application.
//		In one of application dev is chrome extension as well which is to get
//		the data from linkedin by web scraping and post it to client server to build the recruitment data for the client main application.
	}

	static void traverse(Node last) {
		Node p;

		// If list is empty, return.
		if (last == null) {
			System.out.println("List is empty.");
			return;
		}

		// Pointing to first Node of the list.
		p = last.next;

		// Traversing the list.
		do {
			System.out.print(p.data + " ");
			p = p.next;

		} while (p != last.next);

	}

	// Driven code
	public static void main(String[] args) {
		Node last = null;

		last = addToEmpty(last, 6);
		traverse(last);
		System.out.println();
		last = addBegin(last, 4);
		traverse(last);
		System.out.println();
		last = addBegin(last, 2);
		traverse(last);
		System.out.println();
		last = addEnd(last, 8);
		traverse(last);
		System.out.println();
		last = addEnd(last, 12);
		traverse(last);
		System.out.println();
		last = addAfter(last, 10, 8);
		System.out.println();
		traverse(last);
	}
}