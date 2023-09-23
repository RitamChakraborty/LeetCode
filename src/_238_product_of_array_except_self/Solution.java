package _238_product_of_array_except_self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = nums[i] * prefix[i - 1];
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) {
                postfix[i] = nums[i];
            } else {
                postfix[i] = nums[i] * postfix[i + 1];
            }
        }

        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                nums[i] = postfix[i + 1];
            } else if (i == n - 1) {
                nums[i] = prefix[n - 2];
            } else {
                int pre = prefix[i - 1];
                int post = postfix[i + 1];
                nums[i] = pre * post;
            }
        }

        return nums;
    }
}