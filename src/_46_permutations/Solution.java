package _46_permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void permute(int index, int[] arr, List<List<Integer>> result) {
        int n = arr.length;

        if (index == n) {
            List<Integer> list = new ArrayList<>();
            for (int i : arr) list.add(i);
            result.add(list);
        }

        for (int i = index; i < n; ++i) {
            swap(arr, index, i);
            permute(index + 1, arr, result);
            swap(arr, index, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums, result);
        return result;
    }
}