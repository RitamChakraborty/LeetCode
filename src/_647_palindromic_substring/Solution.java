package _647_palindromic_substring;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int k = 0; k < n; ++k) {
            int i = k;
            int j = k;
            while (i >= 0 && j < n && s.charAt(i--) == s.charAt(j++)) ++count;

            i = k;
            j = k + 1;

            while (i >= 0 && j < n && s.charAt(i--) == s.charAt(j++)) ++count;
        }

        return count;
    }
}