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
	/***********************************************************************/
	public static void main(String args[]){
		LinkedList ll=new LinkedList();
		ll.head=new Node(1);
		Node second=new Node(2);
		Node third=new Node(3);
		ll.head.next=second;
		second.next=third;
		ll.printList();System.out.println();
		//push 8 and 9 at front
		ll.push(8);ll.push(9);ll.printList();System.out.println();		
		//push 10 after some node
		ll.insertAfter(ll.head.next.next, 10);ll.printList();System.out.println();
		//append 15 and 16 at last
		ll.append(15);ll.append(16);;ll.printList();System.out.println();
		//delete the head element
		ll.delete(9);ll.printList();System.out.println();
		//delete a in between element 2
		ll.delete(2);ll.printList();System.out.println();
		//delete the last element
		ll.delete(16);ll.printList();System.out.println();
		
		
	}
}
