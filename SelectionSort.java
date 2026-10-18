package JavaCodingExamplePkg;

import java.util.Arrays;
/*
 * we try to find/select if there is any number who is less than the number at minIndex, 
 * if we found it then we swap the number at AssumedMinIndex and at DiscoveredMinIndex
 * 
 * 
 * 
 * “I assume the first unsorted element is the smallest. Then I search 
 * the rest to see if that assumption is wrong. If I find someone smaller, 
 * I update my assumption, and finally swap that smallest number into place.”
 * 
 * 
 * 
 * */
public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = {2,3,5,6,9,8};
		int n=arr.length;
		int minIndex = -1;
		
		for(int i=0;i<n;i++) {
			minIndex = i;
			for(int j=i+1;j<n;j++) {
				if(arr[minIndex] < arr[j]) { //find minimum value at the inner loop
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i]=temp; //then swap the i'th element with arr[minIdx]
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
