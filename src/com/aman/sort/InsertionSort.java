/**
 * 
 */
package com.aman.sort;

/**
 * @author amanb
 *
 */
public class InsertionSort<T> {
	
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
	
	public static void insertionSort(int[] listToSort) {
		for(int i = 0; i < listToSort.length-1; i++) {
			for(int j=i+1;j > 0;j--) {
				if (listToSort[j] < listToSort[j-1]) {
					swap(listToSort,j,j-1);
				}else {
					break;
				}
			}
			printToList(listToSort);
			}
		}
	public static void main(String[] args) {
		int[] al= {4,5,6,2,1,7,10,3,8,9};
		insertionSort(al);
 	}

}
