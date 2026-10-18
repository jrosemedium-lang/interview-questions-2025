package JavaCodingExamplePkg;

public class BinarySearchV2 {
	public static void main(String[] args) {
		 int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};  
		 int targetKey = 21;
		 int i =0, left=0,right=arr.length-1;
		 int mid = 0; boolean flag = false;
		 while(left<=right) {
			 mid = (left + right)/2;
			 if(arr[mid] == targetKey) {
				 flag = true;
				 System.out.println("Key found - "+mid);
				 break;
			 }
			 if(arr[mid]<targetKey) {
				 left = mid + 1;
			 } else if(arr[mid]>targetKey) {
				 right = mid - 1;
			 }
		 }

	
		 if(!flag) {
			 System.out.println("key not found");
		 }
	}
}
