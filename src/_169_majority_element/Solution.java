package _169_majority_element;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElementBruteForce(int[] arr) {
        int n = arr.length;
        int majority = n / 2;

        for (int k : arr) {
            int count = 0;

            for (int i : arr) {
                if (i == k) ++count;
            }

            if (count > majority) return k;
        }

        return -1;
    }

    public int majorityElementOptimal1(int[] arr) {
        int n = arr.length;
        int majority = n / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                if (count == majority) return i;
                else map.put(i, count + 1);
            } else {
                map.put(i, 1);
            }
        }

        return -1;
    }

    public int majorityElement(int[] arr) {
        int n = arr.length;
        int majorityElement = arr[0];
        int count = 1;

        for (int i = 1; i < n; ++i) {
            if (count == 0) {
                majorityElement = arr[i];
                count = 1;
            } else if (arr[i] == majorityElement) {
                count++;
            } else {
                count--;
            }
        }

        return majorityElement;
    }
}
