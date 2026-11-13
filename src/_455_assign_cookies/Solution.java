package _455_assign_cookies;

import java.util.Arrays;

/**
 * Greedy: Sort the greed factors and cookie sizes and greedily the cookie which satisfies the condition
 * Time: O(N * LogN)
 * Space: O(1)
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Thread t1 = new Thread(() -> {
            Arrays.sort(g);
        });

        Thread t2 = new Thread(() -> {
            Arrays.sort(s);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ignore) {
        }

        int i = 0, j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }

        return count;
    }
}
