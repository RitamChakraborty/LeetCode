package _242_valid_anagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mem = new int[26];

        for (char ch : s.toCharArray()) {
            mem[ch - 'a']++;
        }

        for (char ch: t.toCharArray()) {
            mem[ch - 'a']--;
        }

        for (int i : mem) {
            if (i != 0) return false;
        }

        return true;
    }
}