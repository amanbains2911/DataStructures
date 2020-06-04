/**
 * 
 */
package com.aman.binarytrees;

/**
 * @author amanb
 *
 */
public class DepthFirst<T> {
	
	public static void preOrder(Node<Character> root) {
		if(root ==null) {
			return;
		}
		System.out.println(root);
		preOrder(root.getLeftChild());
		preOrder(root.getRighChild());
	}

	public static void inOrder(Node<Character> root) {
		if(root ==null) {
			return;
		}
		inOrder(root.getLeftChild());
		System.out.println(root);
		inOrder(root.getRighChild());
	}
	
	public static void postOrder(Node<Character> root) {
		if(root ==null) {
			return;
		}
		postOrder(root.getLeftChild());
		postOrder(root.getRighChild());
		System.out.println(root);
	}
}
