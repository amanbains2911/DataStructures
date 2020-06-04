/**
 * 
 */
package com.aman.shortestpath;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import com.aman.graphs.Graph;

/**
 * @author amanb
 *
 */
public class DijkstraPath {

	private Map<Integer,DistanceInfoAlgo> buildDistanceTable(Graph graph, int source){
		Map<Integer,DistanceInfoAlgo> hm = new HashMap<>();
		PriorityQueue<VertexInfo> que=new PriorityQueue<>(new Comparator<VertexInfo>() {

			@Override
			public int compare(VertexInfo o1, VertexInfo o2) {
              return ((Integer) o1.getDistance()).compareTo(o2.getDistance());
			}	
		});
		
		 Map<Integer,VertexInfo> vertexInfoMap=new HashMap<>();
		 for(int j=0;j<graph.getVertices();j++) {
			 hm.put(j,new DistanceInfoAlgo());
			 
		 }
		 hm.get(source).setDistance(0);
		 hm.get(source).setLastVertex(source);
		 
		 VertexInfo sourVer=new VertexInfo(source, 0);
		 que.add(sourVer);
		 vertexInfoMap.put(source, sourVer);
		
		  while(!que.isEmpty()) {
			  
			  VertexInfo vert=que.poll();
			  int curr=vert.getVertexId();
			  for(Integer neig : graph.getAdjacentVertices(curr)) {
				  int dis=hm.get(curr).getDistance()+ graph.getWeightedEdge(curr,neig);
			      
				   if(hm.get(neig).getDistance() > dis) {
					   hm.get(neig).setDistance(dis);
					   hm.get(neig).setLastVertex(curr);
					   
					   VertexInfo neighboVertexInfo=vertexInfoMap.get(neig);
					   if(neighboVertexInfo!=null) {
						   que.remove(neighboVertexInfo);
					   }
					   neighboVertexInfo= new VertexInfo(neig,dis);
					   que.add(neighboVertexInfo);
					   vertexInfoMap.put(neig, neighboVertexInfo);				   
					   
				   }		  
			  }	  
			  
		  }	 		 
		 return hm;
	}
	
	public void shortestPath(Graph graph,int source, int destination) {
		 Map<Integer, DistanceInfoAlgo> hm =buildDistanceTable(graph,source);
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
	    	 System.out.println("Dijkstra Algorithm done!!!");
	     }
	 }
	
}
