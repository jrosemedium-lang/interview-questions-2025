package JavaCodingExamplePkg;

public class JavaPatternsV2 {
	public static void main(String[] args) {
	       for(int i=1;i<=5;i++) {
	    	   for(int j=1;j<=5;j++) {
	    		   System.out.print(i);
	    	   }
	    	   System.out.println();
	       }
	       
	       
	       for(int i=1;i<=5;i++) {
	    	   for(int j=1;j<=i;j++) {
	    		   System.out.print(i);
	    	   }
	    	   System.out.println();
	       }
	       System.out.println();
	      
	       System.out.println();
	       for(int i=5;i>=1;i--) {
	    	   for(int j=5;j>=1;j--) {
	    		   System.out.print(i);
	    	   }
	    	   System.out.println();
	       }
	       
	       System.out.println();
	       
	       
	       System.out.println();
	       for(int i=5;i>=1;i--) {
	    	   for(int j=5;j>=i;j--) {
	    		   System.out.print(i);
	    	   }
	    	   System.out.println();
	       }
	       System.out.println();
	       
	       
	       System.out.println();
	       for(int i=5;i>=1;i--) {
	    	   for(int j=i;j>=1;j--) {
	    		   System.out.print(i);
	    	   }
	    	   System.out.println();
	       }
	       
	       System.out.println();
	       
	       System.out.println("--------");
	       System.out.println();
	       for(int i=1;i<=5;i++) {
	    	   for(int j=1;j<=i;j++) {
	    		   System.out.print(i);
	    	   }
	    	   System.out.println();
	       }
	       for(int i=4;i>=1;i--) {
	    	   for(int j=i;j>=1;j--) {
	    		   System.out.print(i);
	    	   }
	    	   System.out.println();
	       }
	       System.out.println();
	       System.out.println("--------");
	       
	       for(int i=5;i>=1;i--) {
	    	   for(int j=1;j<=i;j++) {
	    		   System.out.print("*");
	    	   }
	    	   for(int j=i;j<=5;j++) {
	    		   System.out.print(i);
	    	   }
	    	   for(int j=5;j>=i;j--) {
	    		   System.out.print(i);
	    	   }
 		   System.out.println();
	       }
	       
	       for(int i=1;i<=5;i++) {
	    	   for(int j=1;j<=i;j++) {
	    		   System.out.print("*");
	    	   }
	    	   for(int j=i;j<=5;j++) {
	    		   System.out.print(i);
	    	   }
	    	   for(int j=5;j>=i;j--) {
	    		   System.out.print(i);
	    	   }
 		   System.out.println();
	       }
	       
	       System.out.println("-----------------");
	       for(int i=5;i>=1;i--) {
				for(int j=5;j>=i;j--) {
					System.out.print("  ");
				}
				for(int j=1;j<i;j++) {
					System.out.print(i);
				}
				for(int j=1;j<=i;j++) {
					System.out.print(i);
				}
				System.out.println();
			}
		 
		 for(int i=1;i<=5;i++) {
			 for(int j=5;j>=i;j--) {
				 System.out.print("  ");
			 }
			 for(int j=1;j<=i;j++) {
				 System.out.print(i);
			 }
			 for(int j=2;j<=i;j++) {
				 System.out.print(i);
			 }
			 System.out.println();
		 }
	       
	       
	       
	}
}
