/**
 * 
 */
package com.aman.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author amanb
 *
 */
public class TopologicalSort {

public static List<Integer> sort(Graph graph){
	LinkedList<Integer> que=new LinkedList<>();
    Map<Integer,Integer> indMap= new HashMap<>();
    
    for(int v=0;v<graph.getVertices();v++) {
    	int indegree=graph.getIndegree(v);
    	indMap.put(v,indegree);
    	if(indegree==0) {
    		que.add(v);
    	}
    }
    	List<Integer> sorList=new ArrayList<>();
    	while(!que.isEmpty()) {
    		int vertex=que.pollLast();
    		sorList.add(vertex);
    		
    		List<Integer> adjVertices=graph.getAdjacentVertices(vertex);
    		for(int m:adjVertices) {
    			int updateIndegree=indMap.get(m)-1;
    			indMap.remove(m);
    			indMap.put(m, updateIndegree);
    			
    			if(updateIndegree==0) {
    				que.add(m);
    			}
    		}
    	}
    	if(sorList.size()!=graph.getVertices()) {
    		throw new RuntimeException("The Graph has a cycle");
    	}
    	return sorList;
    }
	
}
	
