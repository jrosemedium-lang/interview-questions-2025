package JavaCodingExamplePkg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParenthesisV2 {
	public static void main(String[] args) {
		String str = "()[{{[]}}]";
		Map<String, String> bracketPair = Map.of(
				"{","}",
				"(",")",
				"[","]"
				);
		System.out.println(
				isValidParenthesis(str,bracketPair)
		);
	}

	private static boolean isValidParenthesis(String str, Map<String, String> bracketPair) {
		ArrayDeque<String> stack = new ArrayDeque<String>();
		
		for(char i:str.toCharArray()) {
			String ch = String.valueOf(i);
			if(bracketPair.containsKey(ch)) {
				stack.push(ch);
			} else if(bracketPair.containsValue(ch)){
				if(stack.isEmpty()) return false;
				String poop = stack.pop();
				String pairred =bracketPair.get(poop);
				if(!pairred.equals(String.valueOf(ch))) {
					return false;
				}
			}
		}
		
		return stack.size()==0;
	}
}