/**
 * 
 */
package com.aman.shortestpath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.aman.graphs.Graph;

/**
 * @author amanb
 *
 */
public class BellmanFord {

	public static Map<Integer, DistanceBell> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceBell> hm = new HashMap<>();
		for (int i = 0; i < graph.getVertices(); i++) {
			hm.put(i, new DistanceBell());
		}
		hm.get(source).setDistance(0);
		hm.get(source).setLastVertex(source);
		LinkedList<Integer> queue = new LinkedList<>();
		for (int numIterations = 0; numIterations < graph.getVertices() - 1; numIterations++) {
			for (int v = 0; v < graph.getVertices(); v++) {
				queue.add(v);
			}
			Set<String> vistedEdges = new HashSet<>();
			while (!queue.isEmpty()) {
				int curr = queue.pollFirst();
				for (int neighbor : graph.getAdjacentVertices(curr)) {
					String edge = String.valueOf(curr) + String.valueOf(neighbor);
					if (vistedEdges.contains(edge)) {
						continue;
					}
					vistedEdges.add(edge);
					int distance = hm.get(curr).getDistance() + graph.getWeightedEdge(curr, neighbor);
					if (hm.get(neighbor).getDistance() > distance) {
						hm.get(neighbor).setDistance(distance);
						hm.get(neighbor).setLastVertex(curr);
					}
				}
			}
		}

		for (int v = 0; v < graph.getVertices(); v++) {
			queue.add(v);
		}
		while (!queue.isEmpty()) {
			int currVertex = queue.pollFirst();
			for (int neighbour : graph.getAdjacentVertices(currVertex)) {
				int distance1 = hm.get(currVertex).getDistance() + graph.getWeightedEdge(currVertex, neighbour);
				if (hm.get(neighbour).getDistance() > distance1) {
					throw new IllegalArgumentException("The Graph has a negative cycle");
				}
			}
		}
		return hm;
	}

	public void shortestPath(Graph graph,int source, int destination) {
		 Map<Integer, DistanceBell> hm =buildDistanceTable(graph,source);
	     Stack<Integer> st=new Stack<>();
	     st.push(destination);
	 
	     int previousVertex=hm.get(destination).getLastVertex();
	     while(previousVertex!=-1 && previousVertex !=source) {
	    	 st.push(previousVertex);
	    	 previousVertex=hm.get(previousVertex).getLastVertex();
	     }
	     if(previousVertex==-1) {
	    	 System.out.println("There is no such path ");
	     }
	     else {
	    	 System.out.println("Smallest path is "+source);
	    	 while(!st.isEmpty()) {
	    		 System.out.println("-->"+st.pop());
	    	 }
	    	 System.out.println("Bellman Ford  Algorithm done!!!");
	     }
	 }

}
