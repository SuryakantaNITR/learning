package com.learning.ds;

public class LinkedListMergeSort {
	
	static Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data=data;
		}
	}
	Node splitListByHalf(Node node) {
		Node back;
		if(node == null || node.next == null) {
			back=null;
		}
		else {
			Node a=head, b=head.next;	
			while(b!=null) {
				b=b.next;
				if(b!=null){
					a=a.next;
					b=b.next;
				}
			}
			back=a.next;
			a.next=null;
		}
		return back;
	}
	
	Node mergeSortUtil(Node a, Node b) {
		Node result=null;
		if(a==null)
			return b;
		
		else if(b==null)
			return a;
		
		if(a.data <= b.data) {
			result = a;
			result.next=mergeSortUtil(a.next, b);
		}
		
		else {
			result = b;
			result.next=mergeSortUtil(a, b.next);
		}
		return result;
	}
	
	void mergeSort(Node node) {
		Node source=node;
		Node b;
		if(source == null || source.next == null) {
			return ;
		}
		
		b=splitListByHalf(source);
		
		mergeSort(source);
		mergeSort(b);
		
		head = mergeSortUtil(source, b);
	}
	
	void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(10);
		head.next.next.next = new Node(7);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(3);
		
		LinkedListMergeSort llm = new LinkedListMergeSort();
		llm.printList();
		llm.mergeSort(head);
		llm.printList();
	}

}
