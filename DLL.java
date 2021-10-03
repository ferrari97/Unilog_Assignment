

import java.util.Scanner;



/**
 * @param <T>
 * Generic Node class for doubly linked list
 */
class Node<T>{
	T data;
	Node<T> previous;
	Node<T> next;

	Node(T ele){
		data = ele;
	}
}

/**
 * @param <T>
 * Generic linked list
 */
class List<T>{
	Node<T> head;

	List(){
		this.head = null;
	}

	public void insertFirst(T ele) {
		Node<T> node = new Node<T>(ele);
		node.next = head;
		node.previous = null;
		if(head != null)
			head.previous = node;
		head = node;
	}

	public void insertLast(T ele) {
		Node<T> node = new Node<T>(ele);
		Node last = head;
		node.next = null;
		if(head == null) {
			node.previous = null;
			head = node;
			return;
		}
		while(last.next != null) 
			last = last.next;

		last.next = node;
		node.previous = last;
	}

	public void insertAt(T ele, int pos) {
		Node<T> node = new Node<T>(ele);
		node.next = null;
		node.previous = null;
		if(pos < 1)
			System.out.println(" Invalid position");
		else if(pos == 1) {
			node.next = head;
			head.previous = node;
			head = node;
		}
		else {
			Node<T> tmp = new Node<T>(null);
			tmp = head;
			for(int i = 1;i < pos-1; i++) {
				if(tmp != null) {
					tmp = tmp.next;
				}
			}
			if(tmp != null) {
				node.next = tmp.next;
				node.previous = tmp;
				tmp.next = node;  
				if(node.next != null)
					node.next.previous = node;
			} else {
				System.out.print(" Previous node is null.");
			}  
		}
	}
	
	public void removeFirst() {

		if(head == null)
			return ;
		Node<T> tmp = new Node<T>(null);
		tmp = head;
		head = head.next;
		head.previous = null;
		tmp = null;
		System.out.println("Deleted first node successfully");

		

	}
	
	public void removeLast() {

		if(head == null)
			return;
		Node last = head;
		
		while(last.next != null) 
			last = last.next;

		last.previous.next = null;
		System.out.println("Deleted last node successfully");


	}
	
	public void removeAt(int pos) {
		
		 if (head == null || pos <= 0)
	            return;
	 
	        Node<T> current = head;
	        int i;
	        for (i = 1; current != null && i < pos; i++)
	        {
	            current = current.next;
	        }
	         
	        if (current == null)
	            return;
	        else if(current.next == null) {
	        	current.previous.next = null;
	        	current = current.previous;
	        }
	        else {
	        	current.previous.next = current.next;
	        	current.next.previous = current.previous;
	        }
	        current = null;
	}
	
	public void searchNode(T data) {
		Node<T> tmp = head;
	    int pos = 0;
	    while (tmp.data != data && tmp.next != null)
	    {
	      pos++;
	      tmp = tmp.next;
	    }
	    if (tmp.data != data)
	    	System.out.println(" Element not found ");
	    else
	    	System.out.println(" Element found at index: "+(pos + 1));
	}
	
	 public void printList()
	    {
	        Node<T> temp = head;
	        if (temp == null)
	            System.out.print("Doubly Linked list is empty");
	 
	        while (temp != null)
	        {
	            System.out.print(" <- "+temp.data + " -> ");
	            temp = temp.next;
	        }
	        System.out.println();
	    }

}
public class DLL {

	public static void main(String[] args) {
		
		List<Integer> ls = new List<>();
		Boolean t = true;
		int n;
		Scanner sc= new Scanner(System.in);
		try {
		do {
		System.out.println(" Enter your choice ");
		System.out.println(" 1. To Add node first");
		System.out.println(" 2. To Add node last ");
		System.out.println(" 3. To Add node at index ");
		System.out.println(" 4. To remove first node");
		System.out.println(" 5. To remove last node");
		System.out.println(" 6. To remove node at index ");
		System.out.println(" 7. To find node ");
		System.out.println(" 8. To display all nodes");
		n = sc.nextInt();
		switch (n) {
		case 1: System.out.println("Enter the element to add First ->");
				int in = sc.nextInt();
				ls.insertFirst(in);
				break;
		case 2: System.out.println("Enter the element to add Last ->");
				int in1 = sc.nextInt();
				ls.insertLast(in1);
				break;
		case 3: System.out.println("Enter the element to add ->");
				int in2 = sc.nextInt();
				System.out.println("Enter the index");
				int index = sc.nextInt();
				ls.insertAt(in2, index);
				break;
		case 4: ls.removeFirst();
				break;
		case 5: ls.removeLast();
				break;
		case 6: System.out.println("Enter the index of node");
				int ind = sc.nextInt();
				ls.removeAt(ind);
				break;
		case 7: System.out.println("Enter the element to find");
				int ele = sc.nextInt();
				ls.searchNode(ele);
				break;		
		case 8: ls.printList();
				break;
				
		default:System.out.println(" Invalid option");
				break;
		}
		System.out.println("Press \'Y\' to continue or \'N\' to exit");
		String ip = sc.next();
		if(ip.equalsIgnoreCase("y"))
			t = true;
		else
			t = false;
		} while (t);
		} catch(Exception e) {
			System.out.println("Exception :"+e);
		} finally {
			sc.close();
			System.out.println(" Exited...");
		}
		
		
		
	}

}
