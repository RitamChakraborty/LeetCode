package _75_sort_colors;

import java.util.Arrays;

class Solution {
    public void sortColorsBruteForce(int[] arr) {
        Arrays.sort(arr);
    }

    public void sortColorsBetter(int[] arr) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int num : arr) {
            if (num == 0) count1++;
            if (num == 1) count2++;
            if (num == 2) count3++;
        }

        for (int i = 0; i < count1; ++i) arr[i] = 0;
        for (int i = 0; i < count2; ++i) arr[i] = 0;
        for (int i = 0; i < count3; ++i) arr[i] = 0;
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] arr) {
        int n = arr.length;
        int l = 0;
        int h = n - 1;
        int i = 0;

        while (i <= h) {
            if (arr[i] == 0) {
                swap(l, i, arr);
                ++l;
            } else if (arr[i] == 2) {
                swap(i, h, arr);
                --i;
                --h;
            }

            ++i;
        }
    }
}