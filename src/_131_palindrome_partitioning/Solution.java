package _131_palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }

    private void partition(int index, String s, Stack<String> stack, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                stack.push(s.substring(index, i + 1));
                partition(i + 1, s, stack, result);
                stack.pop();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(0, s, new Stack<>(), result);
        return result;
    }
}