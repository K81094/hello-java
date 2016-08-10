

//Simple LinkList program
public class LinkedList {
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	//PrintList
	public void printList(Node n){
		//Node n=head;
		while(n!=null){
			System.out.print(n.data +"->");
			n=n.next;
		}
	}
	
	//Push data at front
	public void push(int new_data){
		Node new_node=new Node(new_data);
		new_node.next=head;
		head=new_node;
	}
	
	//Push data after a specific node
	public void insertAfter(Node prev_node,int new_data){
		if(prev_node==null){
			System.out.println("The entered node is null");
		}
		Node new_node=new Node(new_data);
		new_node.next=prev_node.next;
		prev_node.next=new_node;
	}
	
	//Append data at the last
	public void append(int new_data){
		Node new_node=new Node(new_data);
		if(head==null){
			head=new_node;
			return;
		}
		Node last=head;
		while(last.next!=null){
			last=last.next;
		}
		last.next=new_node;
	}
	
	//
	public void delete(int key){
		Node temp=head;
		Node prev=null;
		if(temp!=null && temp.data==key){
			head=temp.next;
			return;
		}
		while(temp!=null && temp.data!=key){
			prev=temp;
			temp=temp.next;
		}
		if(temp==null)
			return;
		
		prev.next=temp.next;
		
	}
	public void deletePosition(int position){
		
		if(head==null){
			System.out.println("Linked List does not exists");
			return ;
		}
		Node temp=head;
		if(position==0){
			head=head.next;
			return;
		}
		
		int counter=0;
		while(temp!=null){
			temp=temp.next;
			counter++;			
			if(counter==position){
			
				temp.next=temp.next.next;			
				return;
			}
			
		}
		if(position>counter){
			System.out.println("there are less elements than the position you mentioned");
			return;
			}
		
	}
	public int Length(){
		int counter=0;
		Node temp=head;
		while(temp!=null){
			counter++;
			temp=temp.next;
			
		}
		return counter;
		
	}
	
	Node reverseIterative(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
           //System.out.println("prev="+prev.data+" current="+current.data+" next="+next.data);
            
        }
        node = prev;
        return node;
    }
	
	Node reverseRecursive(Node node){
		
		return node;
	}
			
			
		
	/***********************************************************************/
	public static void main(String args[]){
		LinkedList ll=new LinkedList();
		head=new Node(1);
		Node second=new Node(2);
		Node third=new Node(3);
		head.next=second;
		second.next=third;
		ll.printList(head);System.out.println();
		
		
		System.out.println("\npush 4 and 5 at front");
		ll.push(4);ll.push(5);ll.printList(head);System.out.println();		
		
		
		System.out.println("\npush 6 after some node");
		ll.insertAfter(ll.head.next.next, 6);ll.printList(head);System.out.println();
		
		
		System.out.println("\nappend 7 and 8 at last");
		ll.append(7);ll.append(8);;ll.printList(head);System.out.println();
		
		
		
		
		System.out.println("\ndelete the head element");
		ll.delete(9);ll.printList(head);System.out.println();
		
		System.out.println("\ndelete any element");
		ll.delete(2);ll.printList(head);System.out.println();

		System.out.println("\ndelete the last element");
		ll.delete(16);ll.printList(head);System.out.println();
		
		//delete element from specific position (head)
		System.out.println("\ndelete from head :");
		ll.deletePosition(0);ll.printList(head);System.out.println();

		System.out.println("\ndelete from position 3 :");
		ll.deletePosition(3);ll.printList(head);System.out.println();

		System.out.println("\ndelete from extra position :");
		ll.deletePosition(13);ll.printList(head);System.out.println();
		
		//Find the length of the linked list
		System.out.println("\nLength of the linked list :");
		System.out.println(ll.Length());
		
		//Find the reverse of the linked list using iterativr method
		System.out.println("\nReverse of the linked list using Iterative Method:");
		head=ll.reverseIterative(head);		
		ll.printList(head);System.out.println();
		
		//Find the reverse of the linked list using recursive method
		System.out.println("Reverse of the linked list using recursive method");
		head=ll.reverseRecursive(head);
		ll.printList(head);
		
		
		
		
	}
}
