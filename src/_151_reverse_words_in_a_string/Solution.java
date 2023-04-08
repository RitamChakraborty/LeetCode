package _151_reverse_words_in_a_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("  the   sky  is blue   "));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (char ch : chars) {
            if (ch == ' ') {
                if (temp.length() != 0) {
                    if (ans.length() == 0) ans.append(temp);
                    else ans = temp.append(" ").append(ans);
                    temp = new StringBuilder();
                }
            } else {
                temp.append(ch);
            }
        }

        if (temp.length() != 0) {
            if (ans.length() == 0) ans.append(temp);
            else ans = temp.append(" ").append(ans);
        }

        return ans.toString();
    }

    public String reverseWords_2(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String word : words) stringJoiner.add(word);
        return stringJoiner.toString();
    }

    public String reverseWords_1(String s) {
        return Arrays.stream(s.trim().split("\\s+"))
                .reduce((a, b) -> b.concat(" ").concat(a))
                .orElse("");
    }
}
