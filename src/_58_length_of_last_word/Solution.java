package _58_length_of_last_word;

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int count = 0;
        int i = chars.length;
        while (i > 0 && chars[--i] != ' ') ++count;
        return count;
    }
}
