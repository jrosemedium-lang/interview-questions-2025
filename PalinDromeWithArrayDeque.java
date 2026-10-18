package JavaCodingExamplePkg;

import java.util.ArrayDeque;

public class PalinDromeWithArrayDeque {
	public static void main(String[] args) {
		String str = "kam";
		ArrayDeque<Character> deque = new ArrayDeque<>();
		for (char ch : str.toCharArray()) {
			deque.push(ch);
		}
		boolean flag = true;
		while(deque.size()>1) {
			char first = deque.pollFirst();
			char last = deque.pollLast();
			if(first != (last)) {
				flag = false;
				System.out.println("not a palindrome");
				break;
			}
		}
		
		if(flag) {
			System.out.println("a palindrome");
		}
		
	} 
}
