/**
 * 
 */
package com.aman.sort;

import java.util.Random;

import com.aman.binaryheap.HeapEmptyException;
import com.aman.binaryheap.HeapFullException;
import com.aman.binaryheap.MinHeap;

/**
 * @author amanb
 *
 */
public class HeapSort<T extends Comparable<?>> {
	private static int[] array;
	private static int[] arr2;

	public static int getLeftChildIndex(int index, int endIndex) {
		int leftChild = 2 * index + 1;
		if (leftChild > endIndex) {
			return -1;
		}
		return leftChild;
	}

	public static int getRightChildIndex(int index, int endIndex) {
		int rightChild = 2 * index + 2;
		if (rightChild > endIndex) {
			return -1;
		}
		return rightChild;
	}

	public static int getParentIndex(int index, int endIndex) {
		if (index < 0 || index > endIndex) {
			return -1;
		}
		return (index - 1) / 2;
	}

	private static void swap(int i1, int i2) {
		int temp = arr2[i1];
		arr2[i1] = arr2[i2];
		arr2[i2] = temp;
	}

	private static void percolateDown(int index, int endIndex) {
		int leftChild = getLeftChildIndex(index, endIndex);
		int rightChild = getRightChildIndex(index, endIndex);
		if (leftChild != -1 && array[leftChild] > array[index]) {
			swap(leftChild, index);
			percolateDown(leftChild, index);
		}
		if (rightChild != -1 && array[rightChild] > array[index]) {
			swap(rightChild, index);
			percolateDown(rightChild, index);
		}
	}

	public static void heapify(int index) {
		int in = getParentIndex(index, index);
		while (index >= 0) {
			percolateDown(in, index);
			in--;
		}
	}

	public static void heapsort() {
		heapify(array.length - 1);

		int endIndex = array.length - 1;
		while (endIndex > 0) {
			swap(0, endIndex);
			endIndex--;
			percolateDown(0, endIndex);
		}
	}

	public static int getmaximum(MinHeap<Integer> minHeap) {
		int last = minHeap.getCount() - 1;
		int lastP = minHeap.getParentIndex(last);
		int firstChil = lastP + 1;
		int max = minHeap.getElementAtindex(firstChil);
		for (int i = firstChil; i <= last; i++) {
			if (max < minHeap.getElementAtindex(i)) {
				max = minHeap.getElementAtindex(i);
			}
		}
		return max;
	}

	public static void printmaximumKElements(int k) throws HeapFullException, HeapEmptyException {
		MinHeap<Integer> heap = new MinHeap<>(Integer.class, k);
		 Random rd = new Random(); // creating Random object
	      int[] arr = new int[5];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt();
	      }
		for (int n : arr) {
			if (heap.isEmpty()) {
				heap.insert(n);
			} else if (!heap.isFull() || heap.getHighPriority() < n) {
				if (heap.isFull()) {
					heap.remove();
				}
				heap.insert(n);
			}
		}
		System.out.println(heap);
	}
}