package com.learning.ds;

public class DetectAndRemoveLoopLL {
	static Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	int detectAndRemoveLoop() {
		Node slow=head, fast=head.next;
		while(fast!=null && fast.next!=null) {
			if(slow == fast)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow == fast) {
			slow = head;
			while(fast.next != slow) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next=null;
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		DetectAndRemoveLoopLL list = new DetectAndRemoveLoopLL();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		Node temp = list.head.next.next;
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next.next.next = new Node(8);
		list.head.next.next.next.next.next.next.next.next = temp;
		
		System.out.println(list.detectAndRemoveLoop());
	}
}
