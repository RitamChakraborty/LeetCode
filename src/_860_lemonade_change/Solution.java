package _860_lemonade_change;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        int twentyCount = 0;

        for (int i : bills) {
            if (i == 5) ++fiveCount;
            else if (i == 10) {
                if (fiveCount == 0) return false;
                ++tenCount;
                --fiveCount;
            } else {
                if (tenCount > 0 && fiveCount > 0) {
                    --tenCount;
                    --fiveCount;
                } else if (fiveCount > 2) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}