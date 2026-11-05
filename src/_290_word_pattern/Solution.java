package _290_word_pattern;

/**
 * Hashing: Make sure bidirectional equality works
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) return false;

        String[] map = new String[26];

        for (int i = 0; i < pattern.length(); i++) {
            int ch = pattern.charAt(i) - 97;

            if (map[ch] != null && !map[ch].equals(strings[i])) return false;

            for (int j = 0; j < 26; j++) {
                if (strings[i].equals(map[j]) && j != ch) return false;
            }

            map[ch] = strings[i];
        }

        return true;
    }
}
