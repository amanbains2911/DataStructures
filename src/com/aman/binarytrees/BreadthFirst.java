/**
 * 
 */
package com.aman.binarytrees;

import com.aman.stack.Queue;
import com.aman.stack.QueueOverflowException;
import com.aman.stack.QueueUnderflowException;

/**
 * @author amanb
 *
 */
public class BreadthFirst<T> {
	
	public static void  breadthFirts(Node<?> root) throws QueueOverflowException, QueueUnderflowException {
		if(root ==null) {
			return;
		}
		@SuppressWarnings("rawtypes")
		Queue<Node> queue=new Queue<>(Node.class);
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			@SuppressWarnings("rawtypes")
			Node node =queue.dequeue();	
			System.out.println(node);
			if(node.getLeftChild()!=null) {
				queue.enqueue(node.getLeftChild());
			}
			if(node.getRighChild()!=null) {
				queue.enqueue(node.getRighChild());
			}
		}
	}
           
}
