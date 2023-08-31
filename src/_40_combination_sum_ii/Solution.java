package _40_combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    private void combinationSum(int index, int[] arr, int target, Stack<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i < arr.length; ++i) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            stack.push(arr[i]);
            combinationSum(i + 1, arr, target - arr[i], stack, result);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        combinationSum(0, arr, target, stack, result);
        return result;
    }
}