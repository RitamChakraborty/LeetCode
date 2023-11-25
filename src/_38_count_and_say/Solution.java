package _38_count_and_say;

class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; ++i) {
            char[] chars = s.toCharArray();
            char current = chars[0];
            int count = 1;
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 1; j < chars.length; ++j) {
                char ch = chars[j];

                if (ch == current) {
                    ++count;
                } else {
                    stringBuilder.append(count).append(current);
                    current = ch;
                    count = 1;
                }
            }

            stringBuilder.append(count).append(current);
            s = stringBuilder.toString();
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(6));
    }
}
// 1 -> 1
// 11 -> 2
// 21 -> 3
// 1211 -> 4
// 111221 -> 5
// 312211 -> 6
// 13112221
// 1112213211
// 312211131221
// 1311223113112211