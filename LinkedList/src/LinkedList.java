//Simple LinkList program
public class LinkedList {
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	public void printList(){
		Node n=head;
		while(n!=null){
			System.out.print(n.data +"->");
			n=n.next;
		}
	}
	
	public void push(int new_data){
		Node new_node=new Node(new_data);
		new_node.next=head;
		head=new_node;
	}
	
	public void insertAfter(Node prev_node,int new_data){
		if(prev_node==null){
			System.out.println("The entered node is null");
		}
		Node new_node=new Node(new_data);
		new_node.next=prev_node.next;
		prev_node.next=new_node;
	}
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
			if(counter==position-1){
				temp.data=temp.next.data;
				temp.next=temp.next.next;			
				return;
			}
			
		}
		if(position>counter){
			System.out.println("there are less elements than the position you mentioned");
			return;
			}
		
	}
	/***********************************************************************/
	public static void main(String args[]){
		LinkedList ll=new LinkedList();
		ll.head=new Node(1);
		Node second=new Node(2);
		Node third=new Node(3);
		ll.head.next=second;
		second.next=third;
		ll.printList();System.out.println();
		
		
		System.out.println("\npush 4 and 5 at front");
		ll.push(4);ll.push(5);ll.printList();System.out.println();		
		
		
		System.out.println("\npush 6 after some node");
		ll.insertAfter(ll.head.next.next, 6);ll.printList();System.out.println();
		
		
		System.out.println("\nappend 7 and 8 at last");
		ll.append(7);ll.append(8);;ll.printList();System.out.println();
		
		
		System.out.println("\ndelete the head element");
		ll.delete(9);ll.printList();System.out.println();
		
		System.out.println("\ndelete any element");
		ll.delete(2);ll.printList();System.out.println();

		System.out.println("\ndelete the last element");
		ll.delete(16);ll.printList();System.out.println();
		
		//delete element from specific position (head)
		System.out.println("\ndelete from head :");
		ll.deletePosition(0);ll.printList();System.out.println();


		System.out.println("\ndelete from position 3 :");
		ll.deletePosition(3);ll.printList();System.out.println();


		System.out.println("\ndelete from extra position :");
		ll.deletePosition(13);ll.printList();System.out.println();
		
		
	}
}
