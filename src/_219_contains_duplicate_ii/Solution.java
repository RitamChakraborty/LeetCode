package _219_contains_duplicate_ii;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Time: O(N * K)
 */
class SolutionBruteForce {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && j <= i + k; j++) {
                if (nums[i] == nums[j]) return true;
            }
        } 

        return false;
    }
}

/**
 * Time: O(1)
 * Space: O(N * K)
 */
class SolutionOptimized {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                var indices = map.get(num);
                int lastIndex = indices.peek();
                if (Math.abs(i - lastIndex) <= k) {
                    System.out.println(map);
                    return true;
                }
                indices.push(i);
            } else {
                Stack<Integer> indices = new Stack<>();
                indices.push(i);
                map.put(num, indices);
            }
        }

        return false;
    }
}

/**
 * Hashing: Keep an eye on the last index where the name number appeared
 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}

