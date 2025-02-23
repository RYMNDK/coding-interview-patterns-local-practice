package Backtracking;

import java.util.List;
import java.util.ArrayList;

public class CombinationsOfSumK {
    public static List<List<Integer>> Solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), 0, nums, target, result);
        return result;
    }

    private static void dfs(List<Integer> combination, int startIndex, int[] nums, int target, List<List<Integer>> result) {
        // Termination condition: If the target is equal to 0, we found a combination
        // that sums to 'k'.
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        // Termination condition: If the target is less than 0, no more valid
        // combinations can be created by adding it to the current combination.
        if (target < 0) {
            return;
        }
        // Starting from startIndex, explore all combinations after adding nums[i].
        for (int i = startIndex; i < nums.length; i++) {
            // Add the current number to create a new combination.
            combination.add(nums[i]);
            // Recursively explore all paths that branch from this new combination.
            dfs(combination, i, nums, target - nums[i], result);
            // Backtrack by removing the number we just added.
            combination.removeLast();  // JDK 21: alternative to remove(combination.size() - 1);
        }
    }
}
