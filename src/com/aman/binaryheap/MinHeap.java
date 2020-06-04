/**
 * 
 */
package com.aman.binaryheap;

/**
 * @author amanb
 * @param <Comaparble>
 *
 */
@SuppressWarnings("rawtypes")
public class MinHeap<T extends Comparable> extends Heap<T> {

	private T[] array;
	private int count =0;
	public MinHeap(Class<T> clazz) {
		super(clazz);

	}

	public MinHeap(Class<T> clazz, int size) {
		super(clazz, size);

	}

	@SuppressWarnings("unchecked")
	protected void siftDown(int index) {
		int left = getLeftChildIndex(index);
		int right = getRightChildIndex(index);

		int smIndex = -1;
		if (left != -1 && right != -1) {
			smIndex = getElementAtindex(left).compareTo(getLeftChildIndex(right)) < 0 ? left : right;
		} else if (left != -1) {
			smIndex = left;
		} else if (right != -1) {
			smIndex = right;
		}
		if (smIndex == -1) {
			return;
		}
		if (getElementAtindex(smIndex).compareTo(getElementAtindex(index)) < 0) {
			swap(smIndex, index);
			siftDown(smIndex);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void siftUp(int index) {
		int par=getParentIndex(index);
		if(par!=-1 && getElementAtindex(index).compareTo(getElementAtindex(par)) <0) {
			swap(par,index);
			siftUp(par);
		}
	}

	public void insert(T value) throws HeapFullException{
		if(count>=array.length) {
			throw new HeapFullException();
		}
		array[count]=value;
		siftUp(count);
		count++;
	}
	
	public T remove( ) throws HeapEmptyException{
		T min=getHighPriority();
		array[0]=array[count-1];
		count--;
		siftDown(count);
		
		return min;
	}

	public T getHighPriority() throws HeapEmptyException {
		if(count == 0) {
			throw new HeapEmptyException();
		}
		return array[0];
	}
}
