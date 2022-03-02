package palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        int z = x, y = 0;
        while (x > 0) {
            y *= 10;
            y += x % 10;
            x /= 10;
        }
        
        return z == y;
    }
}