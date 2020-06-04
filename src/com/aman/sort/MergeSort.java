/**
 * 
 */
package com.aman.sort;

/**
 * @author amanb
 *
 */
public class MergeSort<T> {

	public static void printToList(int[] printlist) {
		for (int el : printlist) {
			System.out.print(el + ",");
		}
		System.out.println();
	}

	public static void split(int[] ls, int[] l1, int[] l2) {
		int index = 0;
		int l2index = l1.length;
		for (@SuppressWarnings("unused")
		int m : ls) {
			if (index < l2index) {
				l1[index] = ls[index];
			} else {
				l2[index - l2index] = ls[index];
			}
			index++;
		}
	}

	public static void merge(int[] ls, int[] l1, int[] l2) {
		int mi = 0, fi = 0, seci = 0;
		while (fi < l1.length && seci < l2.length) {
			if (l1[fi] < l2[seci]) {
				ls[mi] = l1[fi];
				fi++;
			} else if (seci < l2.length) {
				ls[mi] = l2[seci];
				seci++;
			}
			mi++;
		}
		if (fi < l1.length) {
			while (mi < ls.length) {
				ls[mi++] = l1[fi++];
			}
		}
		if (seci < l2.length) {
			while (mi < ls.length) {
				ls[mi++] = l2[seci++];
			}
		}
	}

	public static void mergeSort(int[] listToSort) {
		if (listToSort.length == 1) {
			return;
		}
		int mi = listToSort.length / 2 + listToSort.length % 2;
		int[] fir = new int[mi];
		int[] sec = new int[listToSort.length - mi];
		split(listToSort, fir, sec);
		mergeSort(fir);
		mergeSort(sec);

		merge(listToSort, fir, sec);
		printToList(listToSort);
	}

	public static void main(String[] args) {
		int[] al = { 4, 5, 6, 2, 2,2,2,2,1, 7, 10, 3, 8, 9, 11, 12, 14 };
		mergeSort(al);
	}
}
