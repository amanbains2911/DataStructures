/**
 * 
 */
package com.aman.shortestpath;

/**
 * @author amanb
 *
 */
public class DistanceInfo {
	
	public DistanceInfo() {
		distance = -1;
		vertex = -1;
	}
	private int distance;
	private int vertex;
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @return the vertex
	 */
	public int getVertex() {
		return vertex;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * @param vertex the vertex to set
	 */
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	

}
