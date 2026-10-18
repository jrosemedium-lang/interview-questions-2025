package JavaCodingExamplePkg;

import java.util.ArrayDeque;
import java.util.Map;

public class ValidParenthesisV3 {
	private static boolean isValidParenthesis(String str) {
		ArrayDeque<String> stack = new ArrayDeque<>();
		Map<String, String> bracketPair = Map.of(
				"(",")",
				"{","}",
				"[","]"
		);
		if(str.equals("")) return false;
		char arr[] = str.toCharArray();
		for(Character ch:arr) {
			String chh = Character.toString(ch);
			if(bracketPair.containsKey(chh)) {
				stack.push(chh);
			} else if(
					!stack.isEmpty() &&
					bracketPair.containsValue(chh) &&
					(bracketPair.get(stack.peek())).equals(chh)
					){
				stack.pop();
			} else if(bracketPair.containsValue(chh) && stack.isEmpty()) {
				return false;
			}
		}
		return stack.size() == 0;
	}
	public static void main(String[] args) {
		  String str = "}";
		   System.out.println(
				   isValidParenthesis(str)
		   );
	}
}
