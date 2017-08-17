package com.learning.ds;

class Node {
	int data;
	Node next;
	
	Node (int data) {
		this.data = data;
		this.next=null;
	}
}
public class LinkedListDemo {
	Node head;
	
	void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	Node pushNode(int data) {
		Node temp = new Node(data);
		temp.next=head;
		head=temp;
		return temp;
	}
	
	public static void main(String[] args) {
		LinkedListDemo ll = new LinkedListDemo();
		ll.head=new Node(1);
		ll.pushNode(2);
		ll.pushNode(3);
		ll.pushNode(4);
		ll.pushNode(5);
		
		ll.printList();
	}
}
