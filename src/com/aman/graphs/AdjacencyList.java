package com.aman.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public abstract class AdjacencyList implements Graph {
	
	private List<Node> vertexList = new ArrayList<>();
	private GraphType gtype = GraphType.DIRECTED;
	private int nver = 0;
	
	public AdjacencyList(GraphType gtype, int nver) {
		this.nver = nver;
		for (int i = 0; i < nver; i++) {
			vertexList.add(new Node(i));
		}

		this.gtype = gtype;
	}

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

	public List<Integer> getAdjacentVertices(int v) {
		if( v <0 || v >=nver) {
			throw new IllegalArgumentException("Invalid vertices ");			
		}
		return vertexList.get(v).getAdjacencyVertices();
	}

	public int getIndegree(int v) {
		 if(v<0 || v>=nver) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		int indegree=0;
		for(int i=0; i< nver;i++) {
			if(getAdjacentVertices(i).contains(v)) {
				indegree++;
			 }
			}
		return indegree;
		}

	public  List<Integer> sort(Graph graph){
		LinkedList<Integer> queue=new LinkedList<>();
		Map<Integer,Integer> indMap  =new HashMap<>();
		
		 for(int i=0;i<=graph.getVertices();i++) {
			int inde=getIndegree(i);
			indMap.put(i, inde);
			if(inde==0) {
				queue.add(i);
			}
		}
		 
		 List<Integer> sortedList =new ArrayList<>();
		 while(!queue.isEmpty()) {
			 int ver=queue.pollLast();
			 sortedList.add(ver);
			 List<Integer> adjVer=getAdjacentVertices(ver);
			 for(int k: adjVer) {
				  int up=indMap.get(k)-1;
				  indMap.remove(k);
				  indMap.put(k, up);
				  
				  if(up==0) {
					  queue.add(k);
				  }
			 }
		 }
		 if(sortedList.size()!=graph.getVertices()) {
			 throw new RuntimeException("The Graph had a cycle!!");
		 }
		 return sortedList;
	}
}
