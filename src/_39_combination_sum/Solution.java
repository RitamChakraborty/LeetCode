package _39_combination_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public void combinationSum(int i, int[] arr, int target, Stack<Integer> stack, List<List<Integer>> result) {
        if (i == arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(stack));
            }
            return;
        }

        if (arr[i] <= target) {
            stack.push(arr[i]);
            combinationSum(i, arr, target - arr[i], stack, result);
            stack.pop();
        }
        combinationSum(i + 1, arr, target, stack, result);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        combinationSum(0, arr, target, stack, result);
        return result;
    }
}