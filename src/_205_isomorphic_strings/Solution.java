package _205_isomorphic_strings;

/**
 * Hashing: Bidirectional mapping between the characters of s and t
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sToT = new int[256];
        int[] tToS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int ch1 = s.charAt(i);
            int ch2 = t.charAt(i);

            if (sToT[ch1] != 0 && sToT[ch1] != ch2) return false;
            if (tToS[ch2] != 0 && tToS[ch2] != ch1) return false;

            sToT[ch1] = ch2;
            tToS[ch2] = ch1;
        }

        return true;
    }
}