package JavaCodingExamplePkg;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubStrings {
	public static void main(String[] args) {
	     String str = "abcadabb";
	     int start = 0;
	     Set<String> uniqueStringSet = new LinkedHashSet<>();

	     for (int i = 0; i < str.length(); i++) {
	            for (int j = i + 1; j <= str.length(); j++) {
	            	uniqueStringSet.add(str.substring(i, j));
	            }
	        }
	     System.out.println(uniqueStringSet);
	     int max = 0;
	     for(String eachString:uniqueStringSet) {
	    	 max = Math.max(eachString.length(), max);
	     }
	     final int maximumLength = max;
	     System.out.println();
	    		 uniqueStringSet.stream().filter(eachString -> 
	    		 	eachString.length() == maximumLength)
	    		 .forEach(System.out::println);
	 }
}
