package _48_rotate_image;

class Solution {
    public void rotate(int[][] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int t = l;
            int b = r;

            for (int i = 0; i < r - l; ++i) {
                int tl = arr[t][l + i];
                arr[t][l + i] = arr[b - i][l];
                arr[b - i][l] = arr[b][r - i];
                arr[b][r - i] = arr[t + i][r];
                arr[t + i][r] = tl;
            }

            l++;
            r--;
        }
    }
}