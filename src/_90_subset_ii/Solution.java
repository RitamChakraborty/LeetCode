package _90_subset_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    private void subset(int index, int n, int[] nums, Stack<Integer> stack, List<List<Integer>> result) {
        result.add(new ArrayList<>(stack));

        for (int i = index; i < n; ++i) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            stack.push(nums[i]);
            subset(i + 1, n, nums, stack, result);
            stack.pop();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        subset(0, nums.length, nums, stack, result);
        return result;
    }
}