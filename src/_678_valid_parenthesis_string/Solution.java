package _678_valid_parenthesis_string;

class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(': {
                    min++;
                    max++;
                    break;
                } case ')': {
                    min--;
                    max--;
                    break;
                } default: {
                    --min;
                    ++max;
                }
            }

            if (max < 0) return false;
            if (min < 0) min = 0;
        }

        return min == 0;
    }
}