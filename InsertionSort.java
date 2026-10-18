package JavaCodingExamplePkg;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = {5,4,3,2,1};
		int n = arr.length;
		for(int i=1;i<arr.length;i++) { //start iterating from 1th position 
			int j = i - 1; //set j at 0 i.e., i-1
			int key = arr[i]; //have a temp variable key
			
			while(j>=0 && arr[j]>key) {
				arr[j+1]= arr[j];
				j--;
			}
			
			arr[j+1] = key; //we did j+1 because we want to avoid -1 and want to shift at place before i
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
