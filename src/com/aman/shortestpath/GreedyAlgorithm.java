/**
 * 
 */
package com.aman.shortestpath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import com.aman.graphs.Graph;

/**
 * @author amanb
 *
 */
public class GreedyAlgorithm {

 private Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceInfo> hm = new HashMap<>();
		for (int i = 0; i < graph.getVertices(); i++) {
			hm.put(i, new DistanceInfo());
		}
		hm.get(source).setDistance(0);
		hm.get(source).setVertex(source);

		LinkedList<Integer> queu = new LinkedList<>();
		queu.add(source);

		while (!queu.isEmpty()) {
			int cur = queu.pollLast();
			for (int j : graph.getAdjacentVertices(cur)) {
				int curd = hm.get(j).getDistance();
				if (curd == -1) {
					curd = 1 + hm.get(cur).getDistance();
					hm.get(j).setDistance(curd);
					hm.get(j).setVertex(cur);
					if (!graph.getAdjacentVertices(1).isEmpty()) {
						queu.add(j);
					}
				}
			}

		}
      return hm;
	}
 
 public void shortestPath(Graph graph,int source, int destination) {
	 Map<Integer, DistanceInfo> hm =buildDistanceTable(graph,source);
     Stack<Integer> st=new Stack<>();
     st.push(destination);
 
     int previousVertex=hm.get(destination).getVertex();
     while(previousVertex!=-1 && previousVertex !=source) {
    	 st.push(previousVertex);
    	 previousVertex=hm.get(previousVertex).getVertex();
     }
     if(previousVertex==-1) {
    	 System.out.println("There is no such path ");
     }
     else {
    	 System.out.println("Smallest path is "+source);
    	 while(!st.isEmpty()) {
    		 System.out.println("-->"+st.pop());
    	 }
    	 System.out.println("Greedy Algorithm done!!!");
     }
 }

}
