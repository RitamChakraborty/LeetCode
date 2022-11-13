package _171_excel_sheet_column_number;

/**
 * Multiply the sum by 26 if not first number
 */
class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            if (i != 0) sum *= 26;
            sum += (int) s.charAt(i) - 64;
        }

        return sum;
    }
}