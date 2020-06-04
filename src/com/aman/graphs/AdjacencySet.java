/**
 * 
 */
package com.aman.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amanb
 *
 */
public abstract class AdjacencySet implements Graph {

	private List<Node> vertexList = new ArrayList<>();
	private GraphType gtype = GraphType.DIRECTED;
	private int nver = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aman.graphs.Graph#addEdge(int, int)
	 */
	@Override
	public void addEdge(int v1, int v2) {
		if (v1 >= nver || v1 < 0 || v2 >= nver || v2 < 0) {
			throw new IllegalArgumentException("Vertex Number is not vaild");
		}

		vertexList.get(v1).addEdge(v2);
		if (gtype == GraphType.UNDIRECTED) {
			vertexList.get(v2).addEdge(v1);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aman.graphs.Graph#getAdjacentVertices(int)
	 */
	public List<Integer> getAdjacentVertices(int v) {
		if( v <0 || v >=nver) {
			throw new IllegalArgumentException("Invalid vertices ");			
		}
		return vertexList.get(v).getAdjacencyVertices();
	}

	public AdjacencySet(GraphType gtype, int nver) {
		this.nver = nver;
		for (int i = 0; i < nver; i++) {
			vertexList.add(new Node(i));
		}

		this.gtype = gtype;
	}
	
	

}
