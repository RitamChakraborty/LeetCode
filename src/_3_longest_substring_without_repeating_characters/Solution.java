package _3_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int start = 0;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            while (set.contains(ch)) {
                set.remove(s.charAt(start++));
            }

            set.add(ch);
            result = Integer.max(result, i - start + 1);
        }

        return result;
    }
}

/**
 * Sliding Windows: Use a 256 integer array to track the frequency. If one character is repeated increase the left
 * pointer, until isn't
 * Time: O(N)
 * Space: O(1)
 */
class SolutionOptimized {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) return n;

        int left = 0;
        int maxLen = 0;
        int[] count = new int[256];

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            count[currentChar]++;

            while (count[currentChar] > 1) {
                count[s.charAt(left)]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}