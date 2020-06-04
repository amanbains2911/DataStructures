/**
 * 
 */
package com.aman.stack;

/**
 * @author amanb
 *
 */
public class Element <T>{
	private T data;
	private Element<?> next;
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @return the next
	 */
	public Element<?> getNext() {
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
	public void setNext(Element<?> next) {
		this.next = next;
	}
	public Element(T data, Element<?> next) {
		this.data = data;
		this.next = next;
	}

}
