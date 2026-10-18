package JavaCodingExamplePkg;

import java.util.Arrays;

public class ArrayRotationByReversalAlgorithm {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		leftRotate(arr, 1, 1);
		System.out.println(Arrays.toString(arr));
		rightRotate(arr, 5, 1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void leftRotate(int arr[], int sizeOfArray, int rotateNtimes) {
		rev(arr, 0, rotateNtimes-1);
		rev(arr, rotateNtimes, sizeOfArray-1);
		rev(arr, 0, sizeOfArray-1);
	}
	
	private static void rightRotate(int arr[], int sizeOfArray, int rotateNTime) {
//	    d = d % n; // Handle cases where d >= n
	    rev(arr, 0, sizeOfArray - 1);   // Step 1: Reverse the entire array
	    rev(arr, 0, rotateNTime - 1);   // Step 2: Reverse the first d elements
	    rev(arr, rotateNTime, sizeOfArray - 1);    // Step 3: Reverse the remaining elements
	}
	
	
	private static void rev(int []arr, int i, int j) {
		while(i<=j) {
			int temp = arr[i];
			arr[i]= arr[j];
			arr[j]=temp;
			System.out.println(i+"--------"+j+":"+arr[i]+"----------- "+arr[j]);
			i++;
			j--;
		}
	}
}
