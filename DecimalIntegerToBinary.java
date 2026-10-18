package JavaCodingExamplePkg;

public class DecimalIntegerToBinary {
	public static void main(String[] args) {
		int num = 10;
		int binDigit;
		String strResult = "";
		while(true) {
			 binDigit = num%2;
			 num = num / 2;
			 strResult = strResult.concat(binDigit + "");
			 if(num<2) {
				 binDigit = num;
				 break;
			 }
		}
		 strResult = strResult.concat(binDigit + "");
		System.out.println(strResult);
	}
}
