/**
 * 
 */
package com.aman.binarytrees;

/**
 * @author amanb
 *
 */
public class Node<T> {
	
	private T data;
	private Node<T> leftChild;
	private Node<T>righChild;

	public Node(T data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @return the leftChild
	 */
	public Node<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * @return the righChild
	 */
	public Node<T> getRighChild() {
		return righChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @param righChild the righChild to set
	 */
	public void setRighChild(Node<T> righChild) {
		this.righChild = righChild;
	}
}
