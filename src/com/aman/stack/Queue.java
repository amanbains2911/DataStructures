/**
 * 
 */
package com.aman.stack;

import java.lang.reflect.Array;

/**
 * @author amanb
 *
 */
public class Queue<T> {
	private static final int SPECIAL_EMPTY_VALUE = -1;
	private static int MAX_SIZE = 40;
	private T[] elements;

	private int hd = SPECIAL_EMPTY_VALUE;
	private int tail = SPECIAL_EMPTY_VALUE;

	@SuppressWarnings("unchecked")
	public Queue(Class<T> cla) {
		elements = (T[]) Array.newInstance(cla, MAX_SIZE);
	}

	public boolean isEmpty() {
		return hd == SPECIAL_EMPTY_VALUE;
	}

	public boolean isFull() {
		int nI = (tail + 1) % elements.length;
		return nI == hd;
	}

	public void enqueue(T data) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		tail = (tail + 1) % elements.length;
		elements[tail] = data;

		if (hd == SPECIAL_EMPTY_VALUE) {
			hd = tail;
		}

	}
	
	public T dequeue() throws QueueUnderflowException
	{
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T data =elements[hd];
		if(hd==tail) {
			hd=SPECIAL_EMPTY_VALUE;
		}else {
			hd=(hd + 1) % elements.length;
		}
		return data;}
}

