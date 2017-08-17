package com.learning.ds;


public class LinkedListReverseGroup {
	Node head;
	
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data=data;
		}
	}
	
	public Node reverseByGroup(Node node, int k) {
		Node prev=null, next=null, current=node;
		int count=0;
		while(current != null && count<k) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		
		if(next != null) {
			node.next = reverseByGroup(next, k);
		}
		return prev;
	}
	
	void printList(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListReverseGroup llg = new LinkedListReverseGroup();
		llg.head = llg.new Node(1);
		llg.head.next = llg.new Node(4);
		llg.head.next.next = llg.new Node(10);
		llg.head.next.next.next = llg.new Node(7);
		llg.head.next.next.next.next = llg.new Node(2);
		llg.head.next.next.next.next.next = llg.new Node(3);
		
		llg.printList(llg.head);
		llg.head = llg.reverseByGroup(llg.head, 2);
		llg.printList(llg.head);
	}

}
