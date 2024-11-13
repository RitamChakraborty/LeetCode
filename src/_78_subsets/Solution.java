package _78_subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private void allSubSets(int index, int[] nums, Stack<Integer> stack, List<List<Integer>> answer) {
        if (index == nums.length) {
            answer.add(new ArrayList<>(stack));
            return;
        }

        stack.push(nums[index]);
        allSubSets(index + 1, nums, stack, answer);
        stack.pop();
        allSubSets(index + 1, nums, stack, answer);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        allSubSets(0, nums, stack, answer);
        return answer;
    }
}
