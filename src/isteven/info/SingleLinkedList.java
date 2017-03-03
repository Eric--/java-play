package isteven.info;

import java.util.Scanner;

public class SingleLinkedList {
	
	public static class LinkedListNode{
		int val;
		LinkedListNode next;
		LinkedListNode(int node_val){
			val = node_val;
			next = null;
		}
	}

	public static void main(String[] args) throws Exception{
		
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for(int i = 0; i < 6; i++){
			Scanner sc = new Scanner(System.in);
		    int tmp = sc.nextInt();
			if(i == 0){
				head = tail = insertNode(head, tail, tmp);
			}else{
				tail = insertNode(head, tail, tmp);	
			}
		}
		
		LinkedListNode res = removeNodes1(head, 5);
		System.out.println("......");
		if(res != null){
			while(res.next != null){
				System.out.println(res.val);
				res = res.next;
			}
			System.out.println(res.val);	
		}
	}
	
	static LinkedListNode removeNodes(LinkedListNode list, int x){
		
		if(list.next == null){
			if(list.val > x){
				return null;
			}else{
				return list;
			}
		}else{
			if(list.val > x){
				return removeNodes(list.next, x);
			}else{
				list.next = removeNodes(list.next, x);
				return list;
			}
		}
	}
	
	static LinkedListNode removeNodes1(LinkedListNode list, int x){
		LinkedListNode head = null,tail = null;
		while(list.next != null){
			if(list.val <= x){
				if(head !=null){
					tail = tail.next = list;
				}else{
					head = tail = list;
				} 
			}
			list = list.next;
		}
		return head;
	}
	
	static LinkedListNode insertNode(LinkedListNode head, LinkedListNode tail, int val){
		if(head == null){
			head = new LinkedListNode(val);
			tail = head;
		}else{
			tail.next = new LinkedListNode(val);
			tail = tail.next;
		}
		return tail; 
	}
}
