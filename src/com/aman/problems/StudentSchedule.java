/**
 * 
 */
package com.aman.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.aman.graphs.AdjacencyMatrixGraph;
import com.aman.graphs.Graph;
import com.aman.graphs.TopologicalSort;


/**
 * @author amanb
 *
 */
public class StudentSchedule {

  public  List<String> order(List<String> courseList,Map<String,List<String>> prereqs){
	 Graph coGraph= new AdjacencyMatrixGraph(Graph.GraphType.DIRECTED,courseList);
	  Map<String,Integer> courseIdMap=new HashMap<>();
	  Map<Integer,String> idCourseMap =new HashMap<>();
	  //TreeMap<Integer,String> tm= new TreeMap<>();
	  
	  for(int i=0;i<courseList.size();i++) {
		  courseIdMap.put(courseList.get(i),i);
		  idCourseMap.put(i,courseList.get(i));
	  }
	  
	  for(Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
		   for(String course : prereq.getValue()) {
			   System.out.println(course);
			   coGraph.addEdge(courseIdMap.get(prereq.getKey()),
					   courseIdMap.get(course));
		   }
	  }
	 List<Integer> courseLi=TopologicalSort.sort(coGraph);
	  List<String> c2=new ArrayList<>();
	  for(int courseId : courseLi) {
		  c2.add(idCourseMap.get(courseId));
	  }
	  return c2;
  } 

}
