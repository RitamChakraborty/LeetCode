package _217_contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Use a hash set
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }

        return false;
    }
}

/**
 * Sort the array and check adjacent neighbours
 */
class Solution1 {
    public boolean containsDuplicate(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == arr[i - 1]) return true;
        }

        return false;
    }
}