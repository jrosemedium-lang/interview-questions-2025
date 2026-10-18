package JavaCodingExamplePkg;

import java.util.Arrays;

public class FindSizeOfAMatrix {
	public static void main(String[] args) {
		 int[][] matrix = {
		            {1, 2, 3},
		            {4, 5},
		            {7, 8, 9, 91, 92},
		            {10, 11, 12},
		            {}
		        };

		 System.out.println("Rows are - "+matrix.length);
		 int rowsLength = matrix.length;
		 
		 for (int i = 0; i < rowsLength; i++) {
			int columnLength = matrix[i].length;
			System.out.println(i+1 + "th column length is - "+columnLength);
		}
		 
		 System.out.println("Rows are - " + matrix.length);

        // Use streams to print the number of columns in each row
        Arrays.stream(matrix)
              .forEach(row -> System.out.println((Arrays.asList(matrix).indexOf(row) + 1) 
            		  + "th column length is - " + row.length));
	}
}
