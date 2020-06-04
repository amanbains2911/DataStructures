/**
 * 
 */
package com.aman.stack;

/**
 * @author amanb
 *
 */
public class Stack<T> {

	private static int MAX_SIZE=40;
	private Element<T> top;
	private int size=0;
	
	@SuppressWarnings("unchecked")
	public void push(T data) throws StackOverflowError {
		if(size==MAX_SIZE) {
			throw new StackOverflowError();
			}
	    @SuppressWarnings({ "rawtypes" })
		Element elem =new Element( data, top);
	    top=elem;
	    size++;
		}
		@SuppressWarnings("unchecked")
		public T pop() throws Exception {
			if(size==0) {
				throw new Exception(); 
			}
			T data =(T) top.getData();
			top=(Element<T>) top.getNext();
			size--;
			return data;
		}
		
		public T peek() throws Exception {
			if(size==0) {
				throw new Exception();
			}
			return top.getData();
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		public boolean isFull() {
			return size==MAX_SIZE;
		}
		public int getSize() {
			return size;
		}
}
