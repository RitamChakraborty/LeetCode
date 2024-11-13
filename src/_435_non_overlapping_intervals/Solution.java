package _435_non_overlapping_intervals;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            int compare = Integer.compare(a[0], b[0]);
            if (compare == 0) return Integer.compare(a[1], b[1]);
            return compare;
        });

        int max = arr[0][1];
        int count = 0;

        for (int i = 1; i < arr.length; ++i) {
            int[] a = arr[i];

            if (a[0] < max) {
                ++count;
                max = Integer.min(max, a[1]);
            } else {
                max = a[1];
            }
        }

        return count;
    }
}
