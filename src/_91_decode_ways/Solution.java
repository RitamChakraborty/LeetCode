package _91_decode_ways;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private int solve(String s, int index, int[] mem) {
        if (index == s.length()) return 1;
        char ch1 = s.charAt(index);
        if (ch1 == '0') return 0;
        if (index == s.length() - 1) return 1;
        if (mem[index] != -1) return mem[index];
        char ch2 = s.charAt(index + 1);
        Set<Character> set = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6'));
        int ans = solve(s, index + 1, mem);
        if (ch1 == '1' || (ch1 == '2' && set.contains(ch2))) {
            ans += solve(s, index + 2, mem);
        }

        mem[index] = ans;
        return ans;
    }

    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);
        return solve(s, 0, mem);
    }
}