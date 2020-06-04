/**
 * 
 */
package com.aman.sort;

/**
 * @author amanb
 *
 */
public class ShellSort<T> {
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
	
	public static void insertionSort(int[] listToSort,int startindex,int inc ) {
		for(int i = startindex; i < listToSort.length; i=i+inc) {
			 for(int j=Math.min(i+inc,listToSort.length-1);j-inc>=0;j=j-inc)
				if (listToSort[j] < listToSort[j-inc]) {
					swap(listToSort,j,j-inc);
				}else {
					break;
				}
			}
			printToList(listToSort);
			}
	public static void shellSort(int[] listToSort,int n) {
		int inc=listToSort.length/n;
		 while(inc >= 1) {
			for(int i=0;i<inc;i++) {
				insertionSort(listToSort,i,inc);
			}
			inc=inc/2;
		}
	}
	
	public static void main(String[] args) {
		int[] al= {4,5,6,2,1,7,10,3,8,9};
		shellSort(al,3);
 	}

		
}
