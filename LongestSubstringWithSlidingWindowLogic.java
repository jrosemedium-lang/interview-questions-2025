package JavaCodingExamplePkg;
import java.util.LinkedHashSet;
import java.util.Set;
public class LongestSubstringWithSlidingWindowLogic {
	public static void main(String[] args) {
		String str = "abcabccccbbb";
		
		int start=0, end=0, maxLength=0;
		Set<Character> uniqueCharSet = new LinkedHashSet<>();
		Set<String> uniqueStringSet = new LinkedHashSet<>();
		
		for(end=0; end<str.length();end++) {
			char ch =str.charAt(end);
			
			while(uniqueCharSet.contains(ch)) {
				uniqueCharSet.remove(str.charAt(start));
				start++;
			}
			
			uniqueCharSet.add(ch);
			uniqueStringSet.add(str.substring(start, end+1));
			
			maxLength = Math.max(maxLength, end-start+1);
			
		}
		
		System.out.println(maxLength);
		System.out.println(uniqueStringSet);
	}
}
