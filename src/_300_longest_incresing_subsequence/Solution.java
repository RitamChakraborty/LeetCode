package _300_longest_incresing_subsequence;

import java.util.Arrays;

class Solution {
    public int lis(int index, int prevIndex, int[] arr, int[][] mem) {
        if (index == arr.length) {
            return 0;
        }

        if (mem[index][prevIndex + 1] != -1) return mem[index][prevIndex + 1];
        int len = lis(index + 1, prevIndex, arr, mem);

        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            len = Integer.max(1 + lis(index + 1, index, arr, mem), len);
        } 

        mem[index][prevIndex + 1] = len;
        return len;
    }

    public int lengthOfLIS(int[] nums) {
        int[][] mem = new int[nums.length + 1][nums.length + 1];
        for (int[] i : mem) {
            Arrays.fill(i, -1);
        }

        return lis(0, -1, nums, mem);
    }
}