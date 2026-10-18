package JavaCodingExamplePkg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwapVowelsWithRegex {
	public static void main(String[] args) {
		String text = "Helalo";
		Pattern pattern = Pattern.compile("[aeiouAEIOU]");
	    Matcher matcher = pattern.matcher(text);

	    Integer firstIndex = null;
	    Integer lastIndex = null;

	    while (matcher.find()) {
	        if (firstIndex == null) {
	            firstIndex = matcher.start();
	        }
	        lastIndex = matcher.start();
	    }

	    if (firstIndex == null || lastIndex == null) {
	        System.out.println("nothign to swap");
	    }

	    // Swap vowels
	    char[] chars = text.toCharArray();
	    char temp = chars[firstIndex];
	    chars[firstIndex] = chars[lastIndex];
	    chars[lastIndex] = temp;

	    System.out.println(
	    		new String(chars)
	    		);

	}
}
