package _27_remove_element;

public class Solution {
    /*
    Brute Force
     */
    public int removeElement1(int[] nums, int val) {
        int count = 0;
        int n = nums.length;

        int i = 0;
        int k = 0;

        while (i < n) {
            int j = i;

            while (j < n && nums[j] == val) {
                j++;
                count++;
            }

            if (j < n) {
                nums[k++] = nums[j];
            }

            i = j + 1;
        }

        return n - count;
    }

    /*
    Optimized
     */
    public int removeElement2(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
