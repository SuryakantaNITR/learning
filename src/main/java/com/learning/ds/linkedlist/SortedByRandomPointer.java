package com.learning.ds.linkedlist;


public class SortedByRandomPointer {
	
	public LinkedList getMid(LinkedList head, LinkedList tail) {
		LinkedList fPtr = head, sPtr = head;
		while(fPtr.next != null) {
			sPtr = sPtr.next;
			fPtr = fPtr.next.next;
		}
		return sPtr;
	}
	public LinkedList mergeSort(LinkedList head, LinkedList tail) {
		LinkedList mid = getMid(head, tail);
		return mid;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(3);
		list.next = new LinkedList(2);
		list.next.next = new LinkedList(1);
		list.next.next.next = new LinkedList(4);
		list.next.next.next.next = new LinkedList(5);
		list.next.next.next.next.next = new LinkedList(7);
		list.next.next.next.next.next.next = new LinkedList(6);
		LinkedList tail = list.next.next.next.next.next.next;
		
		LinkedList current = list;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		SortedByRandomPointer s = new SortedByRandomPointer();
		System.out.println(tail.data + " " +s.mergeSort(list, tail).data);
	}

}
