package _91_decode_ways;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SolutionBruteForce {
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

/**
 * Decision tree optimization
 * Set the values for the next and next to next. Initially next to next value should be a valid
 * Based on the current value update the next1 and next2 values
 * Time: O(N)
 * Space: O(1)
 */
class SolutionOptmized {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int next1 = 0;
        int next2 = 1;

        if (s.charAt(n - 1) != '0') {
            next1 = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            int current = s.charAt(i) - 48;
            int next = s.charAt(i + 1) - 48;
            int curr = 0;

            if (current != 0) {
                curr = next1;
            }

            if (current == 1 || (current == 2 && next < 7)) {
                curr += next2;
            }

            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}