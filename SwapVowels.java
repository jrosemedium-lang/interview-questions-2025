package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.List;

public class SwapVowels {
	public static void main(String[] args) {
		String text ="Hello";//Output: Holle
		List<String> vowelList = Arrays.asList("a","e","i","o","u","A","E","I","O","U");
		
		char c1 = (char) text.chars().filter(c -> vowelList.contains(Character.valueOf((char)c).toString())).findFirst().getAsInt();
		String textReverse = new StringBuilder(text).reverse().toString();
		char c2 = (char) textReverse.chars().filter(c -> vowelList.contains(Character.valueOf((char)c).toString())).findFirst().getAsInt();
		
		System.out.println(c1);
		System.out.println(c2);
	
		text = text.replaceFirst(Character.valueOf((char)c2).toString(), Character.valueOf((char)c1).toString());
		System.out.println(text);
		text = text.replaceFirst(Character.valueOf((char)c1).toString(), Character.valueOf((char)c2).toString());
		System.out.println(text);
	}
}
