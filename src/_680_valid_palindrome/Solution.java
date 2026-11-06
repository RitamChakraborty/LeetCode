package _680_valid_palindrome;

class SolutionRecursive {
    boolean validPalindrome(String s, int left, int right, boolean flag) {
        if (left >= right) return true;

        if (s.charAt(left) != s.charAt(right)) {
            if (flag) return validPalindrome(s, left + 1, right, false) || validPalindrome(s, left, right - 1, false);
            else return false;
        }

        return validPalindrome(s, left + 1, right - 1, flag);
    }

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, true);
    }
}

/**
 * Two Pointers: Check one step ahead of left and one step behind right separately
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    private boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }
}