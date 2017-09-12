package com.learning.ds.linkedlist;

public class Sum1AndN {
	
	LinkedList list = null;
	
	public Sum1AndN() {
		
	}
	
	public void addLinkedList(int data) {
		LinkedList LinkedList = new LinkedList(data);
		LinkedList.next = null;
		LinkedList.random = null;
		if(this.list == null)
			list = LinkedList;
		else {
			LinkedList.next = list;
			list = LinkedList;
		}
			
	}
	
	public void printList() {
		LinkedList head = this.list;
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	
	}
	public LinkedList reverseGroup(LinkedList node) {
		LinkedList current = node.next, prev = node, next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node.next = prev;
		return node.next;
	}
	
	public LinkedList calculateSum() {
		LinkedList head = this.list, slowPtr = this.list, fastPtr = this.list.next, lastPtr=this.list;
		
		while(fastPtr != null) {
			lastPtr = fastPtr;
			if(fastPtr.next != null) {
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
			}
			else
				fastPtr = fastPtr.next;	
		}
		
		reverseGroup(slowPtr); 
		System.out.println(" ");
		System.out.println("Reversed Group");
		printList();
		return slowPtr;
	}
	
	public static void main(String[] args) {
		Sum1AndN s = new Sum1AndN();
		s.addLinkedList(1);
		s.addLinkedList(2);
		s.addLinkedList(3);
		s.addLinkedList(4);
		s.addLinkedList(5);
		s.addLinkedList(6);
		s.printList();
		System.out.println(s.calculateSum().data);
	}

}
