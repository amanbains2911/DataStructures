/**
 * 
 */
package com.aman.sort;


/**
 * @author amanb
 *
 */
public class BubbleSort<T> {



	public static void printToList(int[] printlist) {
		for (int el : printlist) {
			System.out.print(el + ",");
		}
		System.out.println();
	}

	public static void swap(int[] printlist, int i, int j) {
		int temp = printlist[i];
		printlist[i] = printlist[j];
		printlist[j] = temp;
	}

	public static void bubbleSort(int[] listToSort) {
		for(int i = 0; i < listToSort.length; i++) {
			boolean swapped=false;
			for(int j=listToSort.length-1;j > i;j--) {
				if (listToSort[j] < listToSort[j-1]) {
					swap(listToSort,j,j-1);
					swapped=true;
				}
			}
			printToList(listToSort);
			if (!swapped) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] al = { 4, 5, 6, 2, 1, 7, 10, 3, 8, 9 };
		bubbleSort(al);
	}
}
