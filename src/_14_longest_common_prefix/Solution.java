package _14_longest_common_prefix;

import java.util.Arrays;

class Solution {
    public String longestCommonPrefixBruteForce(String[] strs) {
        String answer = strs[0];

        for (int i = 1; i < strs.length; ++i) {
            if (answer.isEmpty()) break;
            int j = 0;

            for (char ch : strs[i].toCharArray()) {
                if (j == answer.length() || ch != answer.charAt(j)) break;
                ++j;
            }

            answer = answer.substring(0, j);
        }

        return answer;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String fast = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Integer.min(fast.length(), last.length()); ++i) {
            if (fast.charAt(i) != last.charAt(i)) return sb.toString();
            sb.append(fast.charAt(i));
        }

        return sb.toString();
    }
}