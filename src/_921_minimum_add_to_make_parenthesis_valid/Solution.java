package _921_minimum_add_to_make_parenthesis_valid;

import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            switch (ch) {
                case '(':
                    stack.push(ch);
                    count++;
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        count--;
                    }
                    else count++;
                    break;
            }
        }

        return count;
    }
}