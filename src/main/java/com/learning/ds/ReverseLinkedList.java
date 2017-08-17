package com.learning.ds;


public class ReverseLinkedList {
	static Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void push(Node temp) {
		temp.next=head;
		head=temp;
	}
	
	void printNodes() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
	Node reverseLinkedList() {
		Node prev=null, current=head, next=null;
		while(current != null) {
			next = current.next;
			current.next=prev;
			prev = current;
			current = next;
		}
		head=prev;
		return head;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		head = new Node(1);
		rll.push(new Node(2));
		rll.push(new Node(3));
		rll.push(new Node(4));
		rll.printNodes();
		rll.reverseLinkedList();
		rll.printNodes();
	}

}