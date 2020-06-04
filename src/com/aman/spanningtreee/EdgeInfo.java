/**
 * 
 */
package com.aman.spanningtreee;

/**
 * @author amanb
 *
 */
public class EdgeInfo {
	
	private Integer vertex1;
	private Integer vertex2 ;
	private Integer weight;
	
	public EdgeInfo(Integer vertex1, Integer vertex2, Integer weight) {
		super();
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	/**
	 * @return the vertex1
	 */
	public Integer getVertex1() {
		return vertex1;
	}

	/**
	 * @return the vertex2
	 */
	public Integer getVertex2() {
		return vertex2;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(vertex1)+String.valueOf(vertex2);
	}
}
