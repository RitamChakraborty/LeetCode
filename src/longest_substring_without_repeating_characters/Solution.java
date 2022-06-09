package longest_substring_without_repeating_characters;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pkwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcdba"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcde"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Deque<Character> deque = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (set.contains(ch)) {
                char toRemove;
                max = Integer.max(max, deque.size());

                do {
                    Character character = deque.poll();
                    if (character == null) break;
                    toRemove = character;
                    set.remove(toRemove);
                } while (toRemove != ch);
            }

            deque.add(ch);
            set.add(ch);
        }

        return Integer.max(deque.size(), max);
    }
}