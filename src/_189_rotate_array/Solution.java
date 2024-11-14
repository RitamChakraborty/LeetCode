package _189_rotate_array;

public class Solution {
    /**
     * Bruce Force
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        for (int i = 0; i < k; ++i) {
            int temp = nums[n - 1];

            for (int j = n - 1; j >= 1; --j) {
                nums[j] = nums[j - 1];
            }

            nums[0] = temp;
        }
    }

    /**
     * Time Optimized
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] arr = new int[n];

        System.arraycopy(nums, 0, arr, 0, n);

        for (int i = 0; i < n; ++i) {
            nums[(i + k) % n] = arr[i];
        }
    }

    /**
     * Time and Space Optimized
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}
