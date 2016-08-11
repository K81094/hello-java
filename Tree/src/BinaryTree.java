import java.lang.Math;

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
	int treeHeight(Node node){
	     if (node == null)
	         return 0;
	     else{	        
	         int lDepth = treeHeight(node.left);
	         int rDepth = treeHeight(node.right);
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
	
	int max(int a,int b){
		return (a>b)?a:b;
	}
	
	//Find maximum element of a tree
	int findMax(Node node){
		if(node==null)
			return Integer.MIN_VALUE;
		
		int max=node.data;
		int lmax=findMax(node.left);
		int rmax=findMax(node.right);
		if(max<lmax)
			max=lmax;
		if(max<rmax)
			max=rmax;
		return max;
	}
	
	//Find minimum element of the tree
	int findMin(Node node){
		if(node==null)
			return Integer.MAX_VALUE;
		int min=node.data;
		int lmin=findMin(node.left);
		int rmin=findMin(node.right);
		if(min>lmin)
			min=lmin;
		if(min>rmin)
			min=rmin;
		return min;
	}
	
	//Find Diameter of a Tree     Note : Time Complexity O(n)2    Oh of n square 
	int treeDiameter(Node node){
		if(node==null)
			return 0;
		int leftHeight=treeHeight(node.left);
		int rightHeight=treeHeight(node.right);
		
		int leftDiameter=treeDiameter(node.left);
		int rightDiameter=treeDiameter(node.right);
		
		return Math.max(Math.max(leftDiameter,rightDiameter),(leftHeight+rightHeight+1));
		
	}
	//Print levelOrder Tree traversal
	void printLevelOrder(Node node){
		int h=treeHeight(node);
		for(int i=1;i<=h;i++)
			printGivenLevel (node,i);
	}
	
	
	void printGivenLevel(Node node,int level){
		if(node==null)
			return ;
		if(level==1)
			System.out.print(node.data+" ");
		else if(level>1){
			printGivenLevel(node.left,level-1);
			printGivenLevel(node.right,level-1);
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
		System.out.print("PreOrder  :");
		bt.preOrder(bt.root);
		System.out.print("\nInOrder  :");
		bt.inOrder(bt.root);
		System.out.print("\nPostOrder  :");
		bt.postOrder(bt.root);
		System.out.print("\nLevel Order  :");
		bt.printLevelOrder(bt.root);
		System.out.print("\nTotal Nodes  :");
		System.out.print(bt.totalNodes(bt.root));		
		System.out.print("\nHeight  : " +bt.treeHeight(bt.root));
		System.out.print("\nTotal Leaf Nodes :");
		System.out.print(bt.totalLeafNodes(bt.root));
		System.out.print("\nMirror of  tree :");
		bt.mirrorTree(bt.root);
		bt.preOrder(bt.root);
		System.out.print("\nMaximum value of  tree  :"+bt.findMax(bt.root));
		System.out.print("\nMinimum value of  tree  :"+bt.findMin(bt.root));
		System.out.print("\nDiameter of  tree  :"+bt.treeDiameter(bt.root));
		
		//Operations on Tree 2
		System.out.println("\n----------------------------------------------");
		System.out.print("PreOrder  :");
		btt.preOrder(btt.root);
		System.out.print("\nInOrder  :");
		btt.inOrder(btt.root);
		System.out.print("\nPostOrder :");
		btt.postOrder(btt.root);
		System.out.print("\nLevel Order  :");
		btt.printLevelOrder(btt.root);
		System.out.print("\nTotal Nodes :");
		System.out.print(btt.totalNodes(btt.root));		
		System.out.print("\nHeight : " +btt.treeHeight(btt.root));
		System.out.print("\nTotal Leaf Nodes :");
		System.out.print(btt.totalLeafNodes(btt.root));
		System.out.print("\nMirror of  tree :");
		btt.mirrorTree(btt.root);
		btt.preOrder(btt.root);		
		System.out.print("\nMaximum value of  tree  :"+btt.findMax(btt.root));
		System.out.print("\nMinimum value of  tree  :"+btt.findMin(btt.root));
		System.out.print("\nDiameter of  tree  :"+btt.treeDiameter(btt.root));
		
		
		
	}

}
