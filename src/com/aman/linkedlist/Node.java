/**
 * 
 */
package com.aman.linkedlist;

/**
 * @author amanb
 *
 */
public class Node <T extends Comparable<T>>{
	
	private T data;
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	private Node<T> next;
	/**
	 * @return the data
	 */
	public Node (T data) {
		
		this.data=data;
		setNext(null);
	}
	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(data);
	} 

}
