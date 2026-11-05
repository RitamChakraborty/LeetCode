package _242_valid_anagram;

/**
 * Hashing: As you iterate over make sure the character count cancels each other out.
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97]++;
            count[t.charAt(i) - 97]--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
}