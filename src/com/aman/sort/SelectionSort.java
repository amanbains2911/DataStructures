/**
 * 
 */
package com.aman.sort;

/**
 * @author amanb
 *
 */
public class SelectionSort<T> {

	
	public static void printToList(int[] printlist) {
		for(int el:printlist) {
			System.out.print(el+",");
		}System.out.println();
	}
	
	public static void swap(int[] printlist, int i,int j) {
		int temp=printlist[i];
		printlist[i]=printlist[j];
		printlist[j]=temp;
		}
	
	public static void selectionSort(int[] listToSort) {
		for(int i=0; i<listToSort.length;i++) {
          for(int j=i+1;j<listToSort.length;j++) {
             if(listToSort[i] > listToSort[j]) {
              swap(listToSort,i,j);
              printToList(listToSort);
	       }
       }
   } 
	}
	
	public static void main(String[] args) {
		int[] al= {4,5,6,2,1,7,10,3,8,9};
		selectionSort(al);
 	}
}