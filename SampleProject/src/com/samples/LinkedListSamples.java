package com.samples;

public class LinkedListSamples {

	static ListNode head;
	
	public static void main(String[] args) {
		
		head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		makeAndDeleteNodeWithVal();
	}
	
	public static void makeAndDeleteNodeWithVal(){
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		
		printLinkedList(head);
		printLinkedList(removeElements(head, 3));
		
		ListNode n = new ListNode(1);
		n.next = new ListNode(1);
		printLinkedList(n);
		printLinkedList(removeElements(n, 1));
	}
	
	public static void makeAndGetIntersectionNode(){
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		ListNode head2 = new ListNode(11);
		head2.next = n4;
		
		printLinkedList(head);
		printLinkedList(head2);
		System.out.println(getIntersectionNode(head, head2).data);
		
		ListNode head1 = new ListNode(1);
		ListNode head12 = head1;
		System.out.println(getIntersectionNode(head1, head12).data);
	}
	
	public static void makeAndRemoveDuplicates(){
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(4);
		ListNode n8 = new ListNode(5);
		ListNode n9 = new ListNode(5);
		ListNode n10 = new ListNode(6);
		ListNode n11 = new ListNode(6);
		ListNode n12 = new ListNode(6);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		n11.next = n12;
		n12.next = null;
		
		printLinkedList(head);
		printLinkedList(deleteDuplicatesFromSortedList(head));
		
	}
	
	public static void makeAndCheckPalindrome(ListNode head){
		printLinkedList(head);
		System.out.println("IsPalindrome: " + isPalindrome(head));
		System.out.println("IsPalindrome2: " + isPalindrome2(head));
		
		ListNode newHead = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		newHead.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		printLinkedList(newHead);
		System.out.println("IsPalindrome: " + isPalindrome(newHead));
		System.out.println("IsPalindrome2: " + isPalindrome2(newHead));
		
	}
	
	public static void makeSampleListsAndMerge(){
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(10);
		ListNode n11 = new ListNode(11);
		ListNode n12 = new ListNode(12);

		head1.next = n3;
		n3.next = n5;
		n5.next = n7;
		n7.next = n9;
		n9.next = n11;
		n11.next = null;
		printLinkedList(head1);

		head2.next = n4;
		n4.next = n6;
		n6.next = n8;
		n8.next = n10;
		n10.next = n12;
		n12.next = null;
		
		printLinkedList(head2);
		System.out.println("\nMergedList: ");
		printLinkedList(mergeTwoLists(head1, head2));
	}
	
	public static void printLinkedList(ListNode head){
		ListNode temp = head;
		if(head == null)
			return;
		System.out.println();
		do {
			System.out.print(temp.data + (temp.next == null ? "" : "->"));
			temp = temp.next;
		} while(temp != null);
		System.out.println();
	}
	
	public static void reverseListRecursive(ListNode currentListNode) {
		if (currentListNode == null) {
			return;
		}

		if(currentListNode.next == null){
			head = currentListNode;
			return;
		}
		
		reverseListRecursive(currentListNode.next);
		currentListNode.next.next = currentListNode;
		currentListNode.next = null;
	}

	public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode second = head.next;
		ListNode third = second.next;
		
		second.next = head;
		head.next = null;
		
		if(third == null)
			return head;
		
		ListNode currentListNode = third;
		ListNode previousListNode = second;
		
		while(currentListNode != null){
			ListNode nextListNode = currentListNode.next;
			currentListNode.next = previousListNode;
			previousListNode = currentListNode;
			currentListNode = nextListNode;
		}
		head = previousListNode;
		return head;
	}
	
	public static ListNode reverseBetweenTwoListNodes(ListNode head, int m, int n){
		if(head == null)
			return null;
		ListNode temp = new ListNode(0);
		temp.next = head;
		
		//Save m-1 to join reversed list in the later part of the code
		ListNode pre = temp;
		while(--m > 0) {
			pre = pre.next;
		}
		ListNode first = pre.next; //saving mth node reference that will be the last node after reversing partial list

		//Save n+1 to join reversed list in the later part of the code
		ListNode post = temp;
		while(n-- >= 0){
			post = post.next;
		}
		
		ListNode prev = null;
		ListNode curr = first;
		while(curr != post){
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		pre.next = prev;
		first.next = post;
		
		return head;
	}
	
	public static ListNode removeNthFromLastListNode(ListNode head, int n){
		if(head == null)
			return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		for(int i = 0; i < n; i++){
			fast = fast.next;
		}
		System.out.println();
		System.out.println(fast == null ? "Null" : fast.data);

		if(fast == null){
			head = head.next;
			return head;
		}
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
			System.out.println("Fast: " + (fast == null ? "Null" : fast.data) + " ," + "Slow: " + (slow == null ? "Null" : slow.data));

		}
		
		slow.next = slow.next.next;
		
		return head;
	}
	
	public static void deleteListNode(ListNode node){
		if(node.next == null ){
			return;
		}
		ListNode temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		temp = null;
	}
	
	public static ListNode mergeTwoLists(ListNode head1, ListNode head2){
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		
		ListNode fakeHead = new ListNode(0);
		ListNode temp = fakeHead;
		
		while(temp1 != null && temp2 != null){
			if(temp1.data <= temp2.data){
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		
		if(temp1 != null)
			temp.next = temp1;
		if(temp2 != null)
			temp.next = temp2;
		
		return fakeHead.next;
	}
	
	public static boolean isPalindrome(ListNode head){ //Time O(n) Space O(n)
		if(head == null)
			return true;
		ListNode temp = head;
		ListNode prev = null;
		ListNode curr = new ListNode(head.data);

		while(temp != null){
			ListNode next = temp.next == null ? null : new ListNode(temp.next.data);
			curr.next = prev;
			prev = curr;
			curr = next;
			temp = temp.next;
		}

		ListNode originTemp = head;
		ListNode copyTemp = prev;
		
//		System.out.print("Original: ");
//		printLinkedList(originTemp);
//		System.out.print("Reverse: ");
//		printLinkedList(copyTemp);
		
		while(originTemp != null && copyTemp != null){
			if(originTemp.data != copyTemp.data){
				return false;
			} else {
				originTemp = originTemp.next;
				copyTemp = copyTemp.next;
			}
		}
		
		return true;
	}
	
	// For Time O(n) and space O(1)
	// 1. Use slow and fast iterators to get to center of the list 
	// 2. Reverse the remaining half of the list
	// 3. Compare two halves of the list
	public static boolean isPalindrome2(ListNode head){
		if(head == null)
			return true;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode tempHead = slow.next;
		slow.next = null;
		
		ListNode prev = null;
		ListNode curr = tempHead;
		while(curr != null){
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
				
		ListNode t1 = prev;
		ListNode t2 = head;
		while(t1 != null){
			if(t1.data != t2.data)
				return false;
			else {
				t1 = t1.next;
				t2 = t2.next;
			}
		}
		
		return true;
	}
	
	public static ListNode deleteDuplicatesFromSortedList(ListNode head) {
		ListNode temp = head;
		if(head == null)
			return null;
		
		while(temp.next != null){
			if(temp.data == temp.next.data){
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head;
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		
		ListNode tempA = headA;
		ListNode tempB = headB;
		int sizeA = 0;
		int sizeB = 0;
		
		while(tempA != null){
			sizeA++;
			tempA = tempA.next;
		}
		while(tempB != null){
			sizeB++;
			tempB = tempB.next;
		}
		
		tempA = headA;
		tempB = headB;

		int diff = 0;
		if(sizeA > sizeB){
			diff = sizeA-sizeB;
			while(diff != 0){
				tempA = tempA.next;
				diff--;
			}
		} else {
			diff = sizeB-sizeA;
			while(diff != 0){
				tempB = tempB.next;
				diff--;
			}
		}
		
		while(tempA != null && tempB != null){
			if(tempA == tempB){
				return tempA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		
		return null;
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		ListNode temp = new ListNode(0);
		temp.next = head; 
		
		ListNode n = temp;
		while(n.next != null){
			if(n.next.data == val){
				ListNode next = n.next;
				n.next = next.next;
			} else {
				n = n.next;
			}
		}System.out.println();
		
		return temp.next;
    }
	
}
