/**
 * 
 */
package com.aman.spanningtreee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.aman.graphs.Graph;
import com.aman.shortestpath.VertexInfo;

/**
 * @author amanb
 *
 */
public class PrimAlgorithm {

	@SuppressWarnings("unused")
	private Map<Integer,DistanceInfoPrim> buildDistanceTable(Graph graph, int source){
		Map<Integer,DistanceInfoPrim> hm = new HashMap<>();
		PriorityQueue<VertexInfo> que=new PriorityQueue<>(new Comparator<VertexInfo>() {

			@Override
			public int compare(VertexInfo o1, VertexInfo o2) {
              return ((Integer) o1.getDistance()).compareTo(o2.getDistance());
			}	
		});
		 
		 for(int j=0;j<graph.getVertices();j++) {
			 hm.put(j,new DistanceInfoPrim());
			 
		 }
		 hm.get(source).setDistance(0);
		 hm.get(source).setLastVertex(source);
		 
		 Map<Integer,VertexInfo> vertexInfoMap=new HashMap<>();
		 VertexInfo sourVer=new VertexInfo(source, 0);
		 que.add(sourVer);
		 vertexInfoMap.put(source, sourVer);
		 
		 Set<String> spanngtree=new HashSet<>();
		 Set<Integer> visitedTree=new HashSet<>();
		 
		 while(!que.isEmpty()) {
			 VertexInfo vert=que.poll();
			 int cur=vert.getVertexId();
			 
			 if(visitedTree.contains(cur)) {
				 continue;
			 }
			 visitedTree.add(cur);
			 
			 if(cur!=source) {
				 String edge = String.valueOf(cur) + String.valueOf(hm.get(cur).getLastVertex());
			      if(!spanngtree.contains(edge)) {
			    	  spanngtree.add(edge);
			      }
			 }
			 for(Integer neighbor :graph.getAdjacentVertices(cur)) {
				 int dis= graph.getWeightedEdge(cur,neighbor);
			      
				   if(hm.get(neighbor).getDistance() > dis) {
					   hm.get(neighbor).setDistance(dis);
					   hm.get(neighbor).setLastVertex(cur);
					   
					   VertexInfo neighboVertexInfo=vertexInfoMap.get(neighbor);
					   if(neighboVertexInfo!=null) {
						   que.remove(neighboVertexInfo);
					   }
					   neighboVertexInfo= new VertexInfo(neighbor,dis);
					   que.add(neighboVertexInfo);
					   vertexInfoMap.put(neighbor, neighboVertexInfo);				   
			 }
		 }
		
		 
		 for(String edger: spanngtree) {
			 System.out.println(edger);
			 }
		 }
		 
		 return hm;
		
	 }
}
