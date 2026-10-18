package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SlidingWindowLogicFindMaxOfSubArray {
	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3, windowSize = k;
		List<List<Integer>> myMajorList = new ArrayList<>();
		List<Integer> myMiniList = new ArrayList<>();
		for (int i = 0, l = 0, j = i + 2; i < arr.length; i++) {
			if (i == j) {
				System.out.print(arr[i] + ", ");
				myMiniList.add(arr[i]);
				myMajorList.add(myMiniList);
				System.out.println(" sliding now but check max");
				System.out.println(myMiniList.stream().sorted(Comparator.naturalOrder())
					.skip(windowSize-1).limit(1).findFirst().get());
				myMiniList = new ArrayList<>();
				l++;
				i = l;
				j = i + 2;
			}
			System.out.print(arr[i] + ", ");
			myMiniList.add(arr[i]);
		}

		System.out.println(myMajorList);
		
	}
}
