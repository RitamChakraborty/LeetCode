package _229_majority_element_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> majorityElementBruteForce(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int majorityCount = n / 3;

        for (int i : nums) {
            int count = 0;
            if (result.contains(i)) continue;

            for (int j : nums) {
                if (j == i) ++count;
            }

            if (count > majorityCount) result.add(i);
            if (result.size() == 2) return result;
        }

        return result;
    }

    public List<Integer> majorityElementBetter(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int majorityCount = n / 3;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            int c = map.get(i);
            if (c > majorityCount) result.add(i);
        }

        return result;
    }

    public List<Integer> majorityElement(int[] nums) {
        int elm1 = Integer.MIN_VALUE;
        int elm2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        int majorityCount = nums.length / 3;
        List<Integer> result = new ArrayList<>();

        for (int i : nums) {
            if (cnt1 == 0 && i != elm2) {
                elm1 = i;
                cnt1 = 1;
            } else if (cnt2 == 0 && i != elm1) {
                elm2 = i;
                cnt2 = 1;
            } else if (i == elm1) ++cnt1;
            else if (i == elm2) ++cnt2;
            else {
                --cnt1;
                --cnt2;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int i : nums) {
            if (i == elm1) ++cnt1;
            if (i == elm2) ++cnt2;
        }

        if (cnt1 > majorityCount) result.add(elm1);
        if (cnt2 > majorityCount) result.add(elm2);

        return result;
    }
}
