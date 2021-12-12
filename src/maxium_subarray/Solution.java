package maxium_subarray;

public class Solution {
    public int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxSoFar = 0;

        for (int i : arr) {
            maxSoFar += i;

            if (maxSoFar > max) {
                max = maxSoFar;
            }

            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }

        return max;
    }
}
