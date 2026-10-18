package JavaCodingExamplePkg;

public class ClosestPair {

	public static void main(String[] args) {
		int arr1 []= new int[] {1,4,5,7};
		int arr2 []= new int[] {10, 20, 30, 40};
		
		int arr1Size = arr1.length;
		int arr2Size = arr2.length;
		int targetSum = 0;
		
		printClosestPair(arr1,arr2, arr1Size, arr2Size, targetSum);
	}

	private static void printClosestPair(int[]arr1, int[] arr2, int arr1Size, int arr2Size, int targetSum) {
		int currentMax = Integer.MAX_VALUE;
		int index1 = 0; int index2 = 0;
		int left1 = 0; int right2 = arr2Size-1;
		
		while(left1<arr1Size && right2>=0) {
			if(Math.abs(arr1[left1] + arr2[right2] - targetSum) < currentMax) {
				index1 = left1;
				index2 = right2;
				currentMax = Math.abs(arr1[left1]+arr2[right2] - targetSum);
			}
			if(arr1[left1]+arr2[right2]< targetSum) {
				left1++;
			}else { 
				right2--;
			}
		}
		
		System.out.println("Closest Pair is:"+arr1[index1]+ "---"+ arr2[index2]);
	}
}
