/**
 * 
 */
package com.aman.graphs;

import java.util.List;

/**
 * @author amanb
 *
 */
public class DepthFirstTraversal<T> {
	
	public static void depthFirstTraversal(Graph  graph, int[] visted, int current) {
		if(visted[current]==1) {
			return;
		}
		visted[current]=1;
		List<Integer> list =graph.getAdjacentVertices(current);
		for(int n: list) {
			depthFirstTraversal(graph,visted,n);
		}
		for(int i=0;i<list.size();i++) {
			depthFirstTraversal(graph,visted,i);
		}
		System.out.println(current+ "->");
	}

}
