package JavaCodingExamplePkg;

import java.util.Stack;

public class SimplifyExpression {

    public static String simplify(String expression) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int sign = 1; // 1 for positive, -1 for negative
        stack.push(sign);

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
            	stack.push(stack.peek() * sign); 
            	sign = 1;
            } else if (ch == ')') {
                stack.pop();
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (Character.isLetter(ch)) {
                // Apply the sign
                int currentSign = stack.peek() * sign;
                if (currentSign > 0) {
                    result.append('+').append(ch);
                } else {
                    result.append('-').append(ch);
                }
            }
        }

        // Remove leading '+' if present
        if (result.length() > 0 && result.charAt(0) == '+') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String expression = "a-(b-c)-(a-b+c)";
        String simplified = simplify(expression);
        System.out.println("Original: " + expression);
        System.out.println("Simplified: " + simplified);
    }
}
