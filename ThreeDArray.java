package JavaCodingExamplePkg;

public class ThreeDArray {
		public static void main(String[] args) {
	        // Create a 3D array with dimensions 3x3x3
	        int[][][] array3D = {
	            {
	                {1, 2, 3},
	                {4, 5, 6},
	                {7, 8, 9}
	            },
	            {
	                {10, 11, 12},
	                {13, 14, 15},
	                {16, 17, 18}
	            },
	            {
	                {19, 20, 21},
	                {22, 23, 24},
	                {25, 26, 27}
	            }
	        };

	        // Print the elements of the 3D array
	        for (int i = 0; i < array3D.length; i++) {
	            for (int j = 0; j < array3D[i].length; j++) {
	                for (int k = 0; k < array3D[i][j].length; k++) {
	                    System.out.print(array3D[i][j][k] + " ");
	                }
	                System.out.println(); // Move to the next line after printing a 2D array's row
	            }
	            System.out.println(); // Move to the next "layer" of the 3D array
	        }
	    }
	}
