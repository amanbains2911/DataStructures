/**
 * 
 */
package com.aman.spanningtreee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.aman.graphs.Graph;

/**
 * @author amanb
 *
 */
public class KruskalAlgorithm {

	public void spanningTree(Graph graph) {
		PriorityQueue<EdgeInfo> que = new PriorityQueue<>(new Comparator<EdgeInfo>() {

			@Override
			public int compare(EdgeInfo o1, EdgeInfo o2) {
				return ((Integer) o1.getWeight()).compareTo(o2.getWeight());
			}
		});

		for (int j = 0; j < graph.getVertices(); j++) {
			for (Integer neighbor : graph.getAdjacentVertices(j)) {
				que.add(new EdgeInfo(j, neighbor, graph.getWeightedEdge(j, neighbor)));
			}
		}

		Set<Integer> visitedTree = new HashSet<>();
		Set<EdgeInfo> spanningTree = new HashSet<>();
		Map<Integer, Set<Integer>> edgemap = new HashMap<>();
		for (int v = 0; v < graph.getVertices(); v++) {
			edgemap.put(v, new HashSet<>());
		}
		while (!que.isEmpty() && spanningTree.size() < graph.getVertices() - 1) {
			EdgeInfo current = que.poll();

			edgemap.get(current.getVertex1()).add(current.getVertex2());
			if (hasCycle(edgemap)) {
				edgemap.get(current.getVertex1()).remove(current.getVertex2());
				continue;
			}
			spanningTree.add(current);
			visitedTree.add(current.getVertex1());
			visitedTree.add(current.getVertex2());
		}
		if (visitedTree.size() != graph.getVertices()) {
			System.out.println("Minimum spanning tree not possible");
		} else {
			System.out.println("Minimum Spaning tree using Kruskal algorithhm");
			for (EdgeInfo edge : spanningTree) {
				System.out.println(edge);
			}
		}
	}

	private boolean hasCycle(Map<Integer, Set<Integer>> edgemap) {
		for(Integer source: edgemap.keySet()) {
			LinkedList<Integer> queue=new LinkedList<>();
			queue.add(source);
			Set<Integer> visitedVertices=new HashSet<>();
			while(!queue.isEmpty()) {
				int cur=queue.pollFirst();
				if(visitedVertices.contains(cur)) {
					return true;
				}
				visitedVertices.add(cur);
				queue.addAll(edgemap.get(cur));
			}
		}
		return false;
	}
}
