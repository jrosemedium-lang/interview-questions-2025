package JavaCodingExamplePkg;

import java.util.Stack;

public class ValidParenthesis {

	private static boolean isBracketOpen(char c) {
			switch(c) {
				case '{':
				case '(':
				case '[':
					return  true;
				default:
					return false;
			}
	}
	
	private static boolean areBracketsMatching(char c, char d) {
		if(c == '{' && d == '}')
			return true;
		else if(c == '[' && d == ']')
			return true;
		else if(c == '(' && d == ')')
			return true;
		else 
			return false;
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char i : s.toCharArray()) {
			if(ValidParenthesis.isBracketOpen(i)) {
				stack.push(i);
			}else {
				if(stack.size() == 0) {
					 return false;
				} else {
					if(ValidParenthesis.areBracketsMatching(stack.peek(), i)) {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}
		return stack.size() == 0;
	}
	public static void main(String[] args) {
	 	String s = "(){} [()] {}";
		System.out.println(
				isValid(s)
				);
		
	}
}
