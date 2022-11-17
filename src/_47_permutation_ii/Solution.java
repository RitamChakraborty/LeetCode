package _47_permutation_ii;

import java.util.*;

class Solution {
    private void permute(int index, int n, Map<Integer, Integer> map, Stack<Integer> stack, List<List<Integer>> list) {
        if (index == n) {
            list.add(new ArrayList<>(stack));
            return;
        }

        for (int i : map.keySet()) {
            int count = map.get(i);

            if (count > 0) {
                map.put(i, count - 1);
                stack.push(i);
                permute(index + 1, n, map, stack, list);
                stack.pop();
                map.put(i, count);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        permute(0, nums.length, map, new Stack<>(), list);

        return list;
    }
}