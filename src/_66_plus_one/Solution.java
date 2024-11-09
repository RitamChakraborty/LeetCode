package _66_plus_one;

class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int carry = getCarry(digits, digits.length - 1);

        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] += carry;
            carry = getCarry(digits, i);
        }

        if (carry != 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = carry;
            System.arraycopy(digits, 0, arr, 1, digits.length);
            return arr;
        }

        return digits;
    }

    private int getCarry(int[] digits, int index) {
        int carry = digits[index] / 10;
        digits[index] = digits[index] % 10;
        return carry;
    }
}
