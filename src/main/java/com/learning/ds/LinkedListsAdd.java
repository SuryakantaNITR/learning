package com.learning.ds;

public class LinkedListsAdd {
	int carry;
	
	public Node addSameSize(Node head1, Node head2) {
		if(head1 == null)
			return null;
		
		Node result = new Node(0);
		int sum;
		result.next = addSameSize(head1.next, head2.next);
		
		sum = head1.data+head2.data+carry;
		carry = sum/10;
		sum = sum%10;
		
		result.data=sum;
		
		return result;
		
	}
	public int getSize(Node head) {
		int count=0;
		while(head != null) {
			head=head.next;
			count++;
		}
		return count;
	}
	public void addCarryToList(Node head, Node current, Node result) {
		int sum;
		
		if(head != current) {
			addCarryToList(head.next, current, result);
			sum=head.data+carry;
			sum %= 10;
			carry /= 10;
			
			result = insertNode(head, sum);
		}
		
	}
	
	public Node insertNode(Node head, int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
		return head;
	}
	public Node add(Node head1, Node head2) {
		Node current, result;
		
		if(head1 == null)
			return head2;
		
		else if(head2 == null)
			return head1;
		
		int s1 = getSize(head1);
		int s2 = getSize(head2);
		
		if(s1 == s2)
			return addSameSize(head1, head2);
		
		else {
			int diff=s1-s2;
			if(diff>0) {
				current = head1;
				while(diff>0) {
					current = current.next;
					diff--;
				}
				result = addSameSize(current, head2);
				carry=0;
				addCarryToList(head1, current, result);
				
			}
			else {
				current = head2;
				while(diff>0) {
					current = current.next;
					diff--;
				}
				result = addSameSize(head1, current);
				carry=0;
				addCarryToList(current, head2, result);
			}
			
			if(carry>0)
				insertNode(result, carry);
		}
		return null;
	}
	public void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	public static void main(String[] args) {
		LinkedListsAdd lla = new LinkedListsAdd();
		LinkedListsAdd.Node head1 = lla.new Node(1);
		head1.next = lla.new Node(7);
		head1.next.next = lla.new Node(8);
		
		LinkedListsAdd.Node head2 = lla.new Node(1);
		head2.next = lla.new Node(7);
		head2.next.next = lla.new Node(5);
		head2.next.next.next = lla.new Node(5);
		
		lla.carry=0;
		Node result = lla.add(head1, head2);
		lla.printList(result);
		
	}

}
