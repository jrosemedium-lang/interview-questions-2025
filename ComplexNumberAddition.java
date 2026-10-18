package JavaCodingExamplePkg;

import java.util.function.BiFunction;

class ComplexNumber{
	int realNum;
	int imgNum;
	
	public int getRealNum() {
		return realNum;
	}
	public void setRealNum(int realNum) {
		this.realNum = realNum;
	}
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	
	public int addRealNumbers(int toAddReal) {
		return this.realNum + toAddReal;
	}
	
	public int addImginaryNumbers(int toAddImg) {
		return this.imgNum + toAddImg;
		
	}
	

	public ComplexNumber(int realNum, int imgNum) {
		super();
		this.realNum = realNum;
		this.imgNum = imgNum;
	}
	public ComplexNumber() {
		super();
		// TODO Auto-generated constructor stub
	}
}
public class ComplexNumberAddition {
	public static void main(String[] args) {
		ComplexNumber complexNumber1 = new ComplexNumber(2, 5);
		ComplexNumber complexNumber2 = new ComplexNumber(12, 15);
		
		complexNumber1.setRealNum(complexNumber1.addRealNumbers(complexNumber2.getRealNum()));
		complexNumber1.setImgNum(complexNumber1.addImginaryNumbers(complexNumber2.getImgNum()));
		
		System.out.println(complexNumber1.getRealNum()+ "+" + complexNumber1.getImgNum() + "i");
		
        // Lambdas for adding real and imaginary numbers
        BiFunction<Integer, Integer, Integer> addRealNumbers = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> addImaginaryNumbers = (a, b) -> a + b;

        // Using lambdas to perform addition
        complexNumber1.setRealNum(addRealNumbers.apply(complexNumber1.getRealNum(), complexNumber2.getRealNum()));
        complexNumber1.setImgNum(addImaginaryNumbers.apply(complexNumber1.getImgNum(), complexNumber2.getImgNum()));

        System.out.println(complexNumber1.getRealNum() + "+" + complexNumber1.getImgNum() + "i");
    }
	}

