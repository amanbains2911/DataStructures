/**
 * 
 */
package com.aman.sort;

/**
 * @author amanb
 *
 */
public class QuickSort<T> {
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
	public static int partition(int[] listTosort, int low,int high) {
		int pivot=listTosort[low];
		int l=low;
		int h =high;
		while(l<h) {
			while(listTosort[l]<= pivot && l<h) {
				l++;
			}
			while(listTosort[h] > pivot) {
				h--;
			} if(l<h) {
			swap(listTosort,l,h);
		}
	   }  swap(listTosort,low,h);
	   System.out.println("Pivot -->"+pivot);
	   printToList(listTosort);
	   return h;
	}
	public static void quickSort(int[] list,int low,int high) {
		if(low>=high) {
			return;
		}
		int pivot=partition(list,low,high);
		quickSort(list,low,pivot-1);
		quickSort(list,pivot+1,high);
	}
	
	public static void main(String[] args) {
		int[] al = { 4, 5, 6, 2,1,7,10 ,3, 8, 9, 11, 12, 14 };
		quickSort(al,0,12);
 }

}