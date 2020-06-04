/**
 * 
 */
package com.aman.binaryheap;

import java.lang.reflect.Array;

/**
 * @author amanb
 *
 */
public abstract class Heap<T extends Comparable<?>> {
	private static int MAX_SIZE=40;
	private T[] array;
	private int count =0;
	
	public Heap(Class<T> clazz) {
		this(clazz,MAX_SIZE);	
	}

	@SuppressWarnings("unchecked")
	public Heap(Class<T> clazz, int size) {
		array=(T[]) Array.newInstance(clazz, size);
	}
 
	public int getLeftChildIndex(int index) {
		int leftChild=2*index+1;
		if(leftChild >=count) {
			return -1;
		}
		return leftChild;
	}
	
	public int getRightChildIndex(int index) {
		int rightChild=2*index+2;
		if(rightChild >=count) {
			return -1;
		}
		return rightChild;
	}
	
	public int getParentIndex(int index) {
		if(index <0 || index >count) {
			return -1;
		}
		return (index-1)/2;
	}
	
	protected void swap(int i1, int i2) {
		T temp =array[i1];
		array[i1]=array[i2];
		array[i2]=temp;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean isEmpty() {
		return count ==0;
	}
	public boolean isFull(){
		return count ==array.length;
	}
	
	public T getElementAtindex(int index) {
		return array[index];
	}
}
