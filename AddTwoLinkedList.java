package programs;

import java.util.*;

public class AddTwoLinkedList {
	public static class Node{
		int data;
		Node next;
		Node(int data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public static class LinkedList{
		Node head;
		Node tail;
		int size;
		
		public void addLast(int i) {
			Node temp = new Node(i,null);
			if (size == 0) {
				head = tail = temp;
			}else {
				tail.next = temp;
				tail = temp;
			}
			size++;
		}	
		
		public void printList() {
			Node ptr = head;
			System.out.println("List is : ");
			while(ptr!=null) {
				System.out.print(ptr.data+" ");
				ptr = ptr.next;
			}
		}
		
		public Node reverse(Node node) {
			if (node == null || node.next == null)
				return node;
			
			Node rest = reverse(node.next);
			
			node.next.next = node;
			node.next = null;
			
			return rest;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		LinkedList list = new LinkedList();
		System.out.println("Enter data of first list");
		int wantToAdd = 1;
		while(wantToAdd == 1) {
			System.out.println("Enter data :");
			int data = sc.nextInt();
			list.addLast(data);
			System.out.println("Want to enter : press 1 or 0");
			wantToAdd = sc.nextInt();
		}
		
//		list.printList();
		
		LinkedList list2 = new LinkedList();
		System.out.println("\nEnter data of second list");
		wantToAdd = 1;
		while(wantToAdd == 1) {
			System.out.println("Enter data :");
			int data = sc.nextInt();
			list2.addLast(data);
			System.out.println("Want to enter : press 1 or 0");
			wantToAdd = sc.nextInt();
		}
		
//		list2.printList();
		
		list.head = list.reverse(list.head);
		list2.head = list2.reverse(list2.head);
		
//		System.out.println("\nAfter reversing first Linked list : ");
//		list.printList();
//		
//		System.out.println("\nAfter reversing second Linked list : ");
//		list2.printList();
		
		// Add two linked list
		LinkedList result = new LinkedList();
		result.head = add(list.head,list2.head,result);
		result.head = result.reverse(result.head);
		System.out.println("Ans is : ");
		result.printList();
		
	}

	private static Node add(Node first, Node second, LinkedList result) {
		Node one = first;
		Node sec = second;
		int c = 0;
		while(one != null || sec != null) {
			int data1 = one!=null?one.data:0;
			int data2 = sec!=null?sec.data:0;
			int d = c+data1+data2;
			c = d>=10?1:0;
			int rem = d%10;
			result.addLast(rem);
			if(one!=null)
				one = one.next;
			if(sec!=null)
				sec = sec.next;
		}
		if(c!=0)
			result.addLast(c);
		return result.head;
	}
}
