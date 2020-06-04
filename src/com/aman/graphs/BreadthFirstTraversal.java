/**
 * 
 */
package com.aman.graphs;

import java.util.List;

import com.aman.stack.Queue;
import com.aman.stack.QueueOverflowException;
import com.aman.stack.QueueUnderflowException;

/**
 * @author amanb
 *
 */
public class BreadthFirstTraversal {
	
	public static void breadthFirstTraversal(Graph graph, int[] visted, int current) throws QueueOverflowException, QueueUnderflowException {
		Queue<Integer> qu=new Queue<>(Integer.class);
		qu.enqueue(current);
		
		while(!qu.isEmpty()) {
			int vertex=qu.dequeue();
			
			if(visted[vertex]==1) {
				continue;
			}
			System.out.println(vertex + "->");
			visted[vertex]=1;
			
			List<Integer> li=graph.getAdjacentVertices(vertex);
			for(int n: li) {
				if(visted[n]!=1) {
					qu.enqueue(n);
				}
			}
			// for the unconnected graph 
			for(int i=0;i<visted.length;i++) {
				breadthFirstTraversal(graph,visted,i);
			}
		}
		
	}

}
