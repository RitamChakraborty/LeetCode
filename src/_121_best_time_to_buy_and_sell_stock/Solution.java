package _121_best_time_to_buy_and_sell_stock;

class Solution1 {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < min) {
                min = arr[i];
            }

            maxProfit = Integer.max(maxProfit, (arr[i] - min));
        }

        return maxProfit;
    }
}

/**
 * Sliding Window: Use local minima
 * Time: O(N)
 * Space: O(1)
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int left = 0;
        int right = 1;
        int max = 0;

        while (right < prices.length) {
            int buy = prices[left];
            int sell = prices[right];

            if (buy < sell) {
                max = Integer.max(max, sell - buy);
            } else {
                left = right;
            }

            right++;
        }

        return max;
    }
}