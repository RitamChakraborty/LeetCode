package _88_merge_sorted_array;

import java.util.Arrays;

public class Solution {
    /**
     * Brute Force
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        while (nums1[i] < n) {
            nums3[k++] = nums1[i++];
        }

        while (nums2[j] < n) {
            nums3[k++] = nums2[j++];
        }

        for (k = 0; k < m + n; ++k) {
            nums1[k] = nums3[k];
        }
    }

    /**
     * Optimized 1
     */
    public void mergeSolution1(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (nums1[i] <= nums2[j]) break;
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
            --i;
            ++j;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    private void swap(int[] nums1, int[] nums2, int i, int j) {
        if (nums1[i] > nums2[j]) {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }
    }

    /**
     * Optimized 2
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;

        while (len > 1) {
            len = (len / 2) + (len % 2);
            int left = 0;
            int right = left + len;

            while (right < m + n) {
                if (left < m && right < m) {
                    swap(nums1, nums1, left, right);
                } else if (left >= m) {
                    swap(nums2, nums2, left - m, right - m);
                } else {
                    swap(nums1, nums2, left, right - m);
                }

                left++;
                right++;
            }
        }

        System.arraycopy(nums2, 0, nums1, m, n);
    }

    /**
     * Best
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}