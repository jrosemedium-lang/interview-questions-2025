package JavaCodingExamplePkg;

import java.util.ArrayDeque;
/*
 * 
For every opening bracket, we push the expected closing bracket.
Then, as we process the string:
If we see a closing bracket, it should match the expected one from the top of the stack.
So stack.pop() != ch means it’s a mismatch.
 * 
 * */
public class ValidParenthesisV4 {
	public static boolean isBracketMatching(String str) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
	    for (char ch : str.toCharArray()) {
	        if (ch == '(') stack.push(')');
	        else if (ch == '[') stack.push(']');
	        else if (ch == '{') stack.push('}');
	        else {
//	        	char poopy = stack.pop();
	            if (stack.isEmpty() || stack.pop() != ch) 
	            	return false;
	        }
	    }
	    return stack.isEmpty();
	}

	public static void main(String[] args) {
		String str ="([](){})";
		System.out.println(
				isBracketMatching(str)
				);

	}

}
