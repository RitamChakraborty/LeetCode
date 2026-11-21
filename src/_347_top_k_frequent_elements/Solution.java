package _347_top_k_frequent_elements;

import java.util.*;

/**
 * Bucket Sort: Count the frequencies of the elements.
 * Then taking the frequencies of the element as index save the elements in an array
 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }

        List<Set<Integer>> bucket = new ArrayList<>(Collections.nCopies(nums.length + 1, null));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (bucket.get(value) == null) bucket.set(value, new HashSet<>());
            bucket.get(value).add(key);
        }

        int[] result = new int[k];
        int j = 0;

        for (int i = bucket.size() - 1; i >= 0; i--) {
            if (j == k) break;
            Set<Integer> set = bucket.get(i);
            if (set == null) continue;

            for (int l : set) {
                result[j++] = l;
            }
        }

        return result;
    }
}