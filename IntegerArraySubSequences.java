package JavaCodingExamplePkg;

public class IntegerArraySubSequences {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};

        int n = arr.length;
        int totalSubsequences = (int) Math.pow(2, n);

        for (int i = 0; i < totalSubsequences; i++) {
            System.out.println("\n--- For i = " + i + " ---");

            StringBuilder subsequence = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int bitShift = (1 << j); // 1 shifted left by j positions
                int bitwiseAnd = i & bitShift; // Check if the j-th bit is set

                // Debugging output
                System.out.println("j = " + j + ", 1<<j = " + bitShift + ", i & (1<<j) = " + bitwiseAnd);

                // Include arr[j] if j-th bit in i is set
                if (bitwiseAnd != 0) {
                    subsequence.append(arr[j]).append(" ");
                }
            }

            // Print the current subsequence
            System.out.println("Subsequence: " + subsequence.toString());
        }
	}
}
