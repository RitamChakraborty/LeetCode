package valid_mountain_array;

class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        if (maxIndex == 0 || maxIndex == arr.length - 1) {
            return false;
        }

        // Checking left
        for (int i = maxIndex - 1; i >= 0; --i) {
            if (arr[i] >= max || arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        // Checking right
        for (int i = maxIndex + 1; i < arr.length; ++i) {
            if (arr[i] >= max || arr[i] >= arr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validMountainArray(new int[]{1, 7, 9, 5, 4, 1, 2}));
    }
}