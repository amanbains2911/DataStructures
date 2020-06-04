/**
 * 
 */
package com.aman.binarytrees;

/**
 * @author amanb
 *
 */
public class BinarySearchTree<T> {

	public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
		if (head == null) {
			return node;
		}
		if (node.getData() <= head.getData()) {
			head.setLeftChild(insert(head.getLeftChild(), node));
		} else {
			head.setRighChild(insert(head.getRighChild(), node));
		}

		return head;

	}

	public static Node<Integer> lookUp(Node<Integer> head, int data) {
		if (head == null) {
			return null;
		}
		if (head.getData() == data) {
			return head;
		}
		if (data <= head.getData()) {
			return lookUp(head.getLeftChild(), data);
		} else {
			return lookUp(head.getRighChild(), data);
		}
	}

	public static int minimumValue(Node<Integer> head) {
		if (head == null) {
			return Integer.MIN_VALUE;
		}
		if (head.getLeftChild() == null) {
			return head.getData();
		}
		return minimumValue(head.getLeftChild());
	}
	
	public static int maximumValue(Node<Integer> head) {
		if (head == null) {
			return Integer.MIN_VALUE;
		}
		if (head.getRighChild() == null) {
			return head.getData();
		}
		return maximumValue(head.getRighChild());
	}


	public static int maxDepth(Node<Integer> head) {
		if (head == null) {
			return 0;
		}
		if (head.getRighChild() == null && head.getLeftChild() == null) {
			return head.getData();
		}
		int leftMax = 1 + maxDepth(head.getLeftChild());
		int rightMax = 1 + maxDepth(head.getRighChild());

		return Math.max(leftMax, rightMax);
	}

	public static void mirror(Node<Integer> head) {
		if (head == null) {
			return;
		}

		mirror(head.getLeftChild());
		mirror(head.getRighChild());

		Node<Integer> temp = head.getLeftChild();
		head.setLeftChild(head.getRighChild());
		head.setRighChild(temp);
	}
	
	public static int countTrees(int numNodes) {
		if(numNodes <=1) {
			return 0;
		}
		int sum=0;
		for(int i=1;i<=numNodes;i++) {
			int lefTrees=countTrees(i-1);
			int rigTrees=countTrees(numNodes-i);
			sum=sum+(lefTrees*rigTrees);
		}
		return sum;
	}
	
	public static void printRange(Node<Integer> head,int low,int high) {
		if(head==null) {
			return;
		}
		if(low<=head.getData()) {
			printRange(head.getLeftChild(),low,high);
		}
		else if(low<=head.getData() && head.getData()<=high) {
			System.out.println(head);
		}
		else if(high > head.getData()) {
			printRange(head.getRighChild(), low, high);
		}
	}
	
	public static boolean isBinary(Node<Integer> head,int low,int high) {
	 	   if(head==null)
	 	   {
			  return true;
            }
	 	  if(head.getData()<= low || head.getData() >high) {
	 		  return false;
	 		  
	 	  }
		return isBinary(head.getLeftChild(),low,head.getData()) 
				&& isBinary(head.getRighChild(),head.getData(), high);
     	   }
	
}
