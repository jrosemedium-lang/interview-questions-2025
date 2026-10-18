package JavaCodingExamplePkg;

public class ClosestPairV2 {
	public static void main(String[] args) {
		 int arr1[] = {1, 4, 5, 7};
	        int arr2[] = {10, 20, 30, 40};
	        int target = 42;

	        int i = 0, j = arr2.length - 1;
	        int closestDiff = Integer.MAX_VALUE;
	        int closestX = 0, closestY = 0;

	        while (i < arr1.length && j >= 0) {
	            int sum = arr1[i] + arr2[j];
	            int diff = Math.abs(target - sum);

	            // Update closest pair if the current pair is better
	            if (diff < closestDiff) {
	                closestDiff = diff;
	                closestX = arr1[i];
	                closestY = arr2[j];
	            }

	            // Move pointers based on sum comparison
	            if (sum < target) {
	                i++;  // Move to larger value in arr1
	            } else {
	                j--;  // Move to smaller value in arr2
	            }
	        }

	        System.out.println("Closest pair to target: (" + closestX + ", " + closestY + ")");
	}
}
