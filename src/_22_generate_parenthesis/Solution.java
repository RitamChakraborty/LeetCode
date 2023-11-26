package _22_generate_parenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private void generateParenthesis(int open, int close, int n, Stack<Character> stack, List<String> result) {
        if (open == n && close == n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : stack) stringBuilder.append(ch);
            result.add(stringBuilder.toString());
        } else if (open == n) {
            stack.push(')');
            generateParenthesis(open, close + 1, n, stack, result);
            stack.pop();
        } else if (close <= open) {
            stack.push('(');
            generateParenthesis(open + 1, close, n, stack, result);
            stack.pop();
            stack.push(')');
            generateParenthesis(open, close + 1, n, stack, result);
            stack.pop();
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(0, 0, n, new Stack<>(), result);
        return result;
    }
}