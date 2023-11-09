package _128_logest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int result = 0;

        for (int i : set) {
            if (set.contains(i - 1)) continue;
            int count = 0;
            while (set.contains(i++)) ++count;
            result = Integer.max(result, count);
        }

        return result;
    }
}