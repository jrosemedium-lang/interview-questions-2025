package JavaCodingExamplePkg;

import java.util.Arrays;

public class MergeSortV2 {
	public static void divide(int arr[], int si, int ei) {
		if(si>=ei) {
			return; //either the array is finished, or there is only 1 element
		}
		
		int mid = si + (ei - si) / 2;
		divide(arr, si, mid);
		divide(arr, mid+1, ei);
		conquer(arr, si, mid, ei);
	}
	private static void conquer(int arr[], int si, int mid, int ei) {
		int merged[] = new int[ei-si+1];//0 based index so do -1 
		
		//put elements in merged
		int idx1=si;
		int idx2=mid+1;
		int x =0;
		
		while(idx1<=mid && idx2<=ei) {
			if(arr[idx1] <= arr[idx2]) {
				merged[x++] = arr[idx1++]; 
			}else {
				merged[x++]=arr[idx2++];
			}
		}
		
		//if one array has elements but other doesnt
		while(idx1<= mid) {
			merged[x++]= arr[idx1++]; 
		}
		
		while(idx2<= ei) {
			merged[x++]= arr[idx2++];
		}
		
		//copy merged array into original array
		for(int i=0, j=si; i<merged.length;i++, j++) {
			arr[j]=merged[i];
		}
	}
	public static void main(String[] args) {
		int arr[]= {6,3,9,5,2,8};
		int n = arr.length;
		
		divide(arr, 0,n-1);
		
		System.out.println(Arrays.toString(arr));
	}
}
