package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.List;

public class DisplayAllPermutationCombination {

	    // Method to generate all permutations with logging
	    public static void generatePermutations(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result, int depth) {
	        // Log the current state at the start of this recursive call
	        System.out.println("Depth " + depth + ": Entering -> Current: " + current + ", Used: " + java.util.Arrays.toString(used));

	        if (current.size() == nums.length) { // Base condition: a complete permutation
	            result.add(new ArrayList<>(current)); // Add the current permutation to the result
	            System.out.println("Depth " + depth + ": Found Permutation: " + current);
	            return;
	        }

	        for (int i = 0; i < nums.length; i++) {
	            if (!used[i]) { // If nums[i] has not been used yet
	                used[i] = true; // Mark it as used
	                current.add(nums[i]); // Add it to the current permutation
	                System.out.println("Depth " + depth + ": Pushed " + nums[i]);

	                // Recurse
	                generatePermutations(nums, current, used, result, depth + 1);

	                // Backtrack: Undo the last decision
	                int removed = current.remove(current.size() - 1); // Remove the last added element
	                used[i] = false; // Mark it as unused
	                System.out.println("Depth " + depth + ": Backtracked -> Removed " + removed + ", Current: " + current);
	            }
	        }

	        // Log the state when leaving this recursive call
	        System.out.println("Depth " + depth + ": Leaving -> Current: " + current + ", Used: " + java.util.Arrays.toString(used));
	    }

	    public static void main(String[] args) {
	        int[] nums = {1, 2, 3}; // Input array
	        List<List<Integer>> permutations = new ArrayList<>();
	        System.out.println("Starting Permutations...");
	        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], permutations, 0);

	        // Print all permutations
	        System.out.println("\nAll Permutations:");
	        for (List<Integer> permutation : permutations) {
	            System.out.println(permutation);
	        }
	    }
}
