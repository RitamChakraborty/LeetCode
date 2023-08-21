package _56_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int low = arr[0][0];
        int high = arr[0][1];
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < arr.length; ++i) {
            int[] a = arr[i];
            if (a[0] < high) {
                high = Integer.max(high, a[1]);
            } else {
                list.add(new int[]{low, high});
            }
        }

        list.add(new int[]{low, high});
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); ++i) result[i] = list.get(i);

        return result;
    }
}