/**
 * 
 */
package com.aman.graphs;

import java.util.List;

/**
 * @author amanb
 *
 */
public interface Graph {

	enum GraphType{
		DIRECTED,
		UNDIRECTED
	}
	
	void addEdge(int v1,int v2);
	
    default List<Integer> getAdjacentVertices(int v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	int getVertices();

	int getWeightedEdge(int curr, Integer neig);

	int getIndegree(int v);
	
}
