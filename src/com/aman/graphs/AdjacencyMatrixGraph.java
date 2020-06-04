/**
 * 
 */
package com.aman.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author amanb
 *
 */
public  class AdjacencyMatrixGraph implements Graph {
	
	private int[][] adjacencyMatrix;
	private GraphType gt=GraphType.DIRECTED;
	private int numVertices=0; 
	private List<String> courseList;

	public AdjacencyMatrixGraph(GraphType gt, List<String> courseList) {
		super();
		this.gt = gt;
		this.courseList = courseList;
	}

	/* (non-Javadoc)
	 * @see com.aman.graphs.Graph#addEdge(int, int)
	 */
	@Override
	public void addEdge(int v1, int v2) {
		if(v1>=numVertices || v1<0 || v2>=numVertices || v2 <0) {
			throw new IllegalArgumentException("Vertex Number is not vaild");
		}
		adjacencyMatrix[v1][v2]=1;
		if(gt == GraphType.UNDIRECTED) {
			adjacencyMatrix[v2][v1]=1;
		}

	}

	public AdjacencyMatrixGraph(GraphType gt, int numVertices) {
		this.gt = gt;
		this.numVertices = numVertices;
		
		adjacencyMatrix= new int[numVertices][numVertices];
		for(int i=0;i<numVertices;i++) {
			for(int j=0;j<numVertices;j++) {
				adjacencyMatrix[i][j]=0;
			}
		}
	}
	
	public int getIndegree(int v) {
		 if(v<0 || v>=numVertices) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		int indegree=0;
		for(int i=0; i< numVertices;i++) {
			if(adjacencyMatrix[i][v]!=0) {
				indegree++;
			 }
			}
		return indegree;
		}

	/* (non-Javadoc)
	 * @see com.aman.graphs.Graph#getAdjacentVertices(int)
	 */
	public List<Integer> getAdjacentVertices(int v) {
		if( v <0 || v >=numVertices) {
			throw new IllegalArgumentException("Invalid vertices ");			
		}
		List<Integer> adj= new ArrayList<>();
		for(int i=0; i<numVertices;i++) {
			if(adjacencyMatrix[v][i]==1) {
				adj.add(i);
				
			}
		}
		Collections.sort(adj);
		return adj;
	}

	@Override
	public int getVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeightedEdge(int curr, Integer neig) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
