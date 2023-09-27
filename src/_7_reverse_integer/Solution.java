package _7_reverse_integer;

class Solution {
    public int reverse(int x) {
        int reversed = 0;

       while (x != 0) {
           int rem = x % 10;
           x /= 10;

           if (reversed < Integer.MIN_VALUE / 10 ||
                   (reversed == Integer.MIN_VALUE / 10 && rem < Integer.MIN_VALUE % 10)) return 0;
           if (reversed > Integer.MAX_VALUE / 10 ||
                   (reversed == Integer.MAX_VALUE / 10 && rem > Integer.MAX_VALUE % 10)) return 0;

           reversed = reversed * 10 + rem;
       } 

       return reversed;
    }
}