package JavaCodingExamplePkg;
import java.util.ArrayList;
import java.util.List;
public class DigitalRootProblemV1StringConversion {

	public static void main(String[] args) {
		long num = 12345l;//56;//1234l;
		long attach = 3;
		long tempNum = num;
		long attachTemp = attach;
		StringBuilder numStr = new StringBuilder(tempNum+"");
		//Attach the given number to itself mentioned number of times, get the new number
		while(attachTemp>1) {
			numStr.append(tempNum+"");
			attachTemp--;
		}
		//For the number found above, find the sum of all the digits
		Long sum = findSumOfDigits(numStr.toString());
		//for the sum of all the digits of the number above get the sum of it if it is not single digit
		while(findCountOfDigits(sum.toString())>1) {
			sum = findSumOfDigits(sum.toString());
		}
	}
	public static Long findSumOfDigits(String digitString) {
		String numStrArray[] = digitString.toString().split("");
		long sum = 0l;
		
		for (int i = 0; i < numStrArray.length; i++) {
			sum=Long.parseLong(numStrArray[i])+sum;
		}
		System.out.println(sum);
		return sum;
	}
	public static int findCountOfDigits(String sum) {
		return sum.toString().length();
	}

}
