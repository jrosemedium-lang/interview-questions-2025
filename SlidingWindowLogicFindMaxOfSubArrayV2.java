package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowLogicFindMaxOfSubArrayV2 {
	public static void main(String[] args) {
		int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		List<List<Integer>> myMajorList = new ArrayList<>();
		List<Integer> myMiniList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
		    myMiniList.add(arr[i]);

		    if (myMiniList.size() == k) {
		        myMajorList.add(new ArrayList<>(myMiniList)); // add a copy
		        System.out.println("Max in window: " + myMiniList.stream().max(Integer::compareTo).get());
		        myMiniList.remove(0); // Slide the window by 1
		    }
		}

	}
}
