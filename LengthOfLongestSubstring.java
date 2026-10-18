package JavaCodingExamplePkg;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		 String s = "abcadabb";
	        Map<Character, Integer> map = new HashMap<>();
	        int left = 0, right = 0, res = 0;

	        for (right = 0; right < s.length(); right++) {
	            char ch = s.charAt(right);

	            // If char was seen and is inside current window, move left
	            if (map.containsKey(ch) && map.get(ch) >= left) {
	                left = map.get(ch) + 1;
	            }

	            map.put(ch, right); // update or insert character index
	            res = Math.max(res, right - left + 1);

	            // Optional: Print current valid window
	            System.out.println(s.substring(left, right + 1));
	        }

	        System.out.println("Length of longest unique substring: " + res);
	    }
	
}
