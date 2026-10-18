package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.List;

public class SwapVowelsV2 {
	public static void main(String[] args) {
		String str = "Hello";
	 	List<String> myList = Arrays.asList("A","E","I","O","U","a","e","i","o","u");
	 	
	 	String c1 =  str.chars()
			 		.mapToObj(c -> String.valueOf((char)c))
			 		.filter(c -> myList.contains(c))
			 		.findFirst().get();
	 	
	 	String strReversed = new StringBuilder(str).reverse().toString();
	 	
	 	String c2 =  strReversed.chars()
			 		.mapToObj(c -> String.valueOf((char)c))
			 		.filter(c -> myList.contains(c))
			 		.findFirst().get();
	 	
	 	System.out.println(c1);
	 	System.out.println(c2);
	 	String strCopy = str;
	 	
	 	strCopy = strCopy.replaceFirst(c2,c1);
	 	strCopy = strCopy.replaceFirst(c1,c2);
	 	System.out.println(
	 			strCopy
	 	);
	}
}
