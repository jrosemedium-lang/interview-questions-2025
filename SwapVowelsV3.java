package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.List;

public class SwapVowelsV3 {

	public static void main(String[] args) {
		String test = "hello today is monday";
		String arry[] = test.split("");
		List<String> myVowelArray = new ArrayList<>(List.of("a","e","i","o","u","A","E","I","O","U"));
		int left = 0, right = arry.length-1;
		while(left<right) {
			if (!myVowelArray.contains(arry[left])) {
		        left++;
		    } else if (!myVowelArray.contains(arry[right])) {
		        right--;
		    } else {
		        // Both are vowels, swap them
		        String temp = arry[left];
		        arry[left] = arry[right];
		        arry[right] = temp;
		        left++;
		        right--;
		    }
		}
		System.out.println(String.join("", arry));

	}

}
