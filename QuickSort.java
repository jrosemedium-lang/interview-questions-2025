package JavaCodingExamplePkg;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {2000, 365, 5, 6, 9, 80}; //{5,3,2,4}
        int n = arr.length - 1;
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        quickSort(arr, 0, n);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        	
        	//check if jth element is less than pivot if so, 
			//then place the jth element at the earliest position in the array//
			//if none of the elements of j's iteration are less than pivot, it means pivot is smallest and will go at 0th location
			//other wise if we see an element less than pivot, then swap the element with itself (probably)
			//other wise we must swap the element smaller than pivot with j-1th element 
        	//(NOTE: pivot will not be swapped here)
        	
    	if (low < high) {
    		int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
    	}
//            System.out.println("Calling partition for range [" + low + ", " + high + "]");
//            System.out.println("Pivot is now at index " + pivotIndex + ", Array: " + Arrays.toString(arr));
            
    		
    }

    private static int partition(int[] arr, int low, int high) {
//        System.out.println("Pivot Element: " + pivot + ", Range: [" + low + ", " + high + "]");
        
    	int pivot = arr[high];
        int i = low - 1;//I want to keep my pivot here at the end of this traverse
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
//                System.out.println("Swapping elements: " + arr[i] + " and " + arr[j]);
                
//            System.out.println("Array after iteration " + j + ": " + Arrays.toString(arr));
        }//last element greater than pivot as per J's traverse is here!
        
        i++;
        
        //i stops at the point where i knows that after this point there is no 
		//element smaller than pivot do i++, come at the point greater than pivot, 
		//this means i++ is greater than pivot, so swap this i++th element with pivot
		//so we ensure that we catching the first element greater than pivot then only swapping
        
        
        System.out.println("Swapping pivot: " + pivot + " with element at index " + i + ": " + arr[i]);
        
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;//why temp is not kept in pivot?
        //because pivot is temporary variable, no use of keeping in pivot
        //originally pivot is arr[high]
        
        System.out.println("Array after placing pivot: " + Arrays.toString(arr));
        return i;
    }
}
