/**
 * 
 */
package com.aman.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author amanb
 *
 */
public class Node {
	
	
	/**
	 * @return the adjSet
	 */
	public Set<Integer> getAdjSet() {
		return adjSet;
	}

	private int vertex;
	private Set<Integer> adjSet=new HashSet<>();
	
	public Node(int vertex) {
		this.vertex = vertex;
	}
	
	/**
	 * @return the vertex
	 */
	public int getVertex() {
		return vertex;
	}

	public void addEdge(int vertexNumber) {
		adjSet.add(vertexNumber);
	}
	
	public List<Integer> getAdjacencyVertices(){
		List<Integer> sortedLsit=new ArrayList<>(adjSet);
	
	 Collections.sort(sortedLsit);
	 return sortedLsit;
	}
}
