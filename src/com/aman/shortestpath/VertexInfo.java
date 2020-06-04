/**
 * 
 */
package com.aman.shortestpath;

/**
 * @author amanb
 *
 */
public class VertexInfo {

	private int vertexId;
	private int distance;

	public VertexInfo(int vertexId, int distance) {
		this.vertexId = vertexId;
		this.distance = distance;
	}

	/**
	 * @return the vertexId
	 */
	public int getVertexId() {
		return vertexId;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

}
