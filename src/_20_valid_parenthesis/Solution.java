package _20_valid_parenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                stack.push(map.get(ch));
            } else if (stack.isEmpty() || ch != stack.pop()) return false;
        }

        return stack.isEmpty();
    }
}

/**
 * Stack: For every opening push the closing in the stack
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
            }
        }

        return stack.isEmpty();
    }
}