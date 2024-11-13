package _1646_get_maximum_in_generated_array;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 20; ++i) {
            System.out.println(i + ":" + solution.getMaximumGenerated(i));
        }
    }

    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        int max = 1;

        for (int i = 1; 2 * i + 1 <= n; ++i) {
            arr[2 * i] = arr[i];
            arr[2 * i + 1] = arr[i] + arr[i + 1];

            max = Integer.max(Integer.max(arr[2 * i], arr[2 * i + 1]), max);
        }

        return max;
    }
}