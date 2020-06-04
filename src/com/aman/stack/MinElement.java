/**
 * 
 */
package com.aman.stack;

/**
 * @author amanb
 *
 */
public  class MinElement {

	/**
	 * @param args
	 */
	
 private Stack<Integer> s1= new Stack<>();
 private Stack<Integer> s2= new Stack<>();
 
 public void push(int data) throws Exception{
	 int min = data;
	 if(!s2.isEmpty()) {
		 if(min>s2.peek()) {
			 min=s2.peek();
		 }
	 }
	 s1.push(data);
	 s2.push(min);
 }
 
 public int pop() throws Exception{
	 s2.pop();
	 return s1.pop();
 }
 
 public int getMin() throws Exception{
	 return s1.peek();
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
