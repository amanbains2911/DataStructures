/**
 * 
 */
package com.aman.stack;

/**
 * @author amanb
 *
 */
public class QueueBuildWithTwoStacks<T> {

	private Stack<T> fs = new Stack<>();
	private Stack<T> rs = new Stack<>();

	public QueueBuildWithTwoStacks() {

	}

	public boolean isFull() {
		return fs.isFull() || rs.isFull();
	}

	public boolean isEmpty() {
		return fs.isEmpty() && rs.isEmpty();
	}

	public void enqueue(T data) throws StackOverflowError, Exception {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		try {
			if (fs.isEmpty()) {
				while (!rs.isEmpty()) {
					fs.push(rs.pop());
				}
			}
			fs.push(data);
		} catch (StackOverflowException | StackUnderflowException e) {
			throw new QueueOverflowException();
		}
	}

	public T dequeue() throws StackOverflowError, Exception {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		try {
			if (rs.isEmpty()) {
				while (!fs.isEmpty()) {
					rs.push(fs.pop());
				}
			}
			return rs.pop();
		} catch (StackOverflowException | StackUnderflowException se) {
			throw new QueueOverflowException();
		}

	}
}
