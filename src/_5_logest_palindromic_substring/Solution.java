package _5_logest_palindromic_substring;

/**
 * A palindrome with odd length, standing in the middle left and right should have same characters
 * For even length we just have to iterate both on the left and the right check the equality of every character
 */
class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int max = 1;
        int start = 0;
        int end = 1;

        for (int i = 0; i < n; ++i) {
            int j = i - 1;
            int k = i + 1;

            while (j >= 0 && k < n && chars[j] == chars[k]) {
                int localMax = k - j + 1;

                if (localMax > max) {
                    max = localMax;
                    start = j;
                    end = k + 1;
                }

                --j;
                ++k;
            }

            j = i;
            k = i + 1;

            while (j >= 0 && k < n && chars[j] == chars[k]) {
                int localMax = k - j + 1;

                if (localMax > max) {
                    max = localMax;
                    start = j;
                    end = k + 1;
                }

                --j;
                ++k;
            }

        }

        return s.substring(start, end);
    }
}