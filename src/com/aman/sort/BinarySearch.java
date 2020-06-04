/**
 * 
 */
package com.aman.sort;

/**
 * @author amanb
 *
 */
public class BinarySearch<T> {
	
	public static int binarySearch(int[] sortedList , int number) {
		int min=0;
		int max=sortedList.length-1;
		
		while(min<=max) {
			int mid= min +(max-min)/2;
			if(sortedList[mid]==number) {
				return mid;
			}if(sortedList[mid]> number) {
				max=mid-1;
			}else {
				min=mid+1;
			}
		} return -1;
	}

	public static void main(String[] args) {
		//int[] al = { 4, 5, 6, 2,1,7,10 ,3, 8, 9, 11, 12, 14 };
		int[] als= {1,2,3,4,5,6,7,8,9,10,11,12,14};
		int y=binarySearch(als,5);
		System.out.println("Shinda->"+y);
 }
}
