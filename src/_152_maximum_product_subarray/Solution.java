package _152_maximum_product_subarray;

class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = 1;
        int minSoFar = 1;
        int res = nums[0];

        for (int i : nums) res = Integer.max(res, i);

        for (int num : nums) {
            if (num == 0) {
                maxSoFar = 1;
                minSoFar = 1;
                continue;
            }

            int temp = Integer.max(Integer.max(maxSoFar * num, minSoFar * num), num);
            minSoFar = Integer.min(Integer.min(maxSoFar * num, minSoFar * num), num);
            maxSoFar = temp;
            res = Integer.max(res, maxSoFar);
        }

        return res;
    }
}