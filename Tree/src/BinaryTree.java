class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int key){
		data=key;
		left=null;
		right=null;
	}
}

public class BinaryTree {
	Node root;
	//Creation of Default Tree
	public BinaryTree() {
		root=null;
	}
	//PreOrder Traversal of Tree
	void preOrder(Node root){
		if(root==null)
			return;
		System.out.print(root.data+ " ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	//InOrder Traversal of Tree
	void inOrder(Node root){
		if(root==null)
			return ;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	//PostOrder Traversal of Tree
	void postOrder(Node root){
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
		
	}
	//Height of tree
	int maxDepth(Node node){
	     if (node == null)
	         return 0;
	     else{	        
	         int lDepth = maxDepth(node.left);
	         int rDepth = maxDepth(node.right);
	         if (lDepth > rDepth)
	             return (lDepth + 1);
	          else
	             return (rDepth + 1);
	     }
	 }
	//Total Nodes in a Tree
	int totalNodes(Node node){
		if(node==null)
			return 0;
		
		return 1+totalNodes(node.left)+totalNodes(node.right);
	}
	//Total Leaf Nodes in a Tree
	int totalLeafNodes(Node root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		else
			return totalLeafNodes(root.left)+totalLeafNodes(root.right);
	}
	//Mirror of a tree
	void mirrorTree(Node root){
		if(root==null)
			return;
		else{
			mirrorTree(root.left);
			mirrorTree(root.right);
		Node temp;
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		}
	}
	
	public static void main(String args[]){
		
		//Tree 1 object
		BinaryTree bt=new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);
		bt.root.left.left=new Node(4);
		bt.root.left.right=new Node(5);
		//Tree 2 Object
		
		BinaryTree btt=new BinaryTree();
		btt.root=new Node(1);
		btt.root.left=new Node(2);
		btt.root.right=new Node(3);
		btt.root.left.left=new Node(4);
		btt.root.left.right=new Node(5);
		btt.root.left.left.left=new Node(6);
		
		//Operations on Tree1
		System.out.print("PreOrder Tree traversal of tree1 :");
		bt.preOrder(bt.root);
		System.out.print("\nInOrder Tree traversal of tree1 :");
		bt.inOrder(bt.root);
		System.out.print("\nPostOrder Tree traversal of tree1 :");
		bt.postOrder(bt.root);
		System.out.print("\nTotal Nodes of tree1 :");
		System.out.print(bt.totalNodes(bt.root));		
		System.out.print("\nHeight of tree is : " +bt.maxDepth(bt.root));
		System.out.print("\nTotal Leaf Nodes in tree1 :");
		System.out.print(bt.totalLeafNodes(bt.root));
		System.out.print("\nMirrot of  tree1 :");
		bt.mirrorTree(bt.root);
		bt.preOrder(bt.root);
		
		//Operations on Tree 2
		System.out.println("\n----------------------------------------------");
		System.out.print("PreOrder Tree traversal of tree1 :");
		btt.preOrder(btt.root);
		System.out.print("\nInOrder Tree traversal of tree1 :");
		btt.inOrder(btt.root);
		System.out.print("\nPostOrder Tree traversal of tree1 :");
		btt.postOrder(btt.root);
		System.out.print("\nTotal Nodes of tree1 :");
		System.out.print(btt.totalNodes(btt.root));		
		System.out.print("\nHeight of tree is : " +btt.maxDepth(btt.root));
		System.out.print("\nTotal Leaf Nodes in tree1 :");
		System.out.print(btt.totalLeafNodes(btt.root));
		System.out.print("\nMirrot of  tree1 :");
		btt.mirrorTree(btt.root);
		btt.preOrder(btt.root);
		
		
	}

}
