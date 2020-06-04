/**
 * 
 */
package com.aman.spanningtreee;

/**
 * @author amanb
 *
 */
public class DistanceInfoPrim {
	
	private int distance;
	private int lastVertex;
	
	/**
	 * 
	 */
	public DistanceInfoPrim() {
		distance=Integer.MAX_VALUE;
		lastVertex=-1;
	}
	
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}


	/**
	 * @return the lastVertex
	 */
	public int getLastVertex() {
		return lastVertex;
	}


	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}


	/**
	 * @param lastVertex the lastVertex to set
	 */
	public void setLastVertex(int lastVertex) {
		this.lastVertex = lastVertex;
	}




}
