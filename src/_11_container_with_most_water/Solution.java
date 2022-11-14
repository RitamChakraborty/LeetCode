package _11_container_with_most_water;

class Solution {
    public int maxArea(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int max = 0;

        while (left < right) {
            max = Integer.max(max, Integer.min(arr[left], arr[right]) * (right - left));

            if (arr[left] == arr[right]) {
                ++left;
            } else if (arr[left] > arr[right]) {
                --right;
            } else if (arr[right] > arr[left]) {
                ++left;
            }
        }

        return max;
    }
}