package JavaCodingExamplePkg;

public class PascalTriangle {
	public static void main(String[] args) {
		int rows = 5;
		/*
		System.out.println("Right angle Triangle with  j columns");
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+"  ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Right angle Triangle with i rows");
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i+"  ");
			}
			System.out.println();
		} 

		System.out.println();
		System.out.println("Inverted Right angle Triangle with i rows");
		for (int i = rows; i >= 1; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i+"  ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Inverted equilateral Triangle with 5 starting and reverse i loop");
		for (int i = rows; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("  ");
			}
			for (int j = rows; j >=i ; j--) {
				System.out.print(" "+j + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("equilateral Triangle with 1 starting and forward i loop");
		for(int i = 1; i <= rows; i++) {
			for(int j = rows; j >=i ; j--) {
				System.out.print("*");
			}
			
			for (int j = 1; j <= i ; j++) {
				System.out.print(" "+i+" ");
			}
			
			System.out.println();
		}*/
		int n = 5; // number of rows
		for (int i = 0; i < n; i++) {
		    for (int j = 5; j >= i; j--) {
		        System.out.print("  ");
		    }
		    int num = 1;
		    for (int j = 0; j <= i; j++) {
		        System.out.print(num+"  ");
		        num = num * (i - j) / (j + 1);
		    }
		    System.out.println();
		}
		
		
	}
}
