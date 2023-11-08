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