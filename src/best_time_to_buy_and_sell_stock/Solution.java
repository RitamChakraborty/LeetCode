package best_time_to_buy_and_sell_stock;

class Solution {
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