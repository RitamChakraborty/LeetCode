package _643_maximum_average_subarray_i;

/**
 * Sliding Window: After computing till K, remove last add new
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i = 0;

        while (i < k) {
            sum += nums[i++];
        }

        int max = sum;

        while (i < nums.length) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Integer.max(max, sum);
            i++;
        }

        return (double) max / (double) k;
    }
}
