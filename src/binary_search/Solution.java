package binary_search;

public class Solution {

    private int binarySearch(int[] arr, int start, int end, int n) {
        if (start < end) {
            if (arr[start] == n) {
                return start;
            } else if (arr[end] == n) {
                return end;
            }

            int mid = (start + end) / 2;

            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                return binarySearch(arr, mid + 1, end, n);
            } else if (arr[mid] > n) {
                return binarySearch(arr, start, mid - 1, n);
            }
        }

        return -1;
    }

    public int binarySearch(int[] arr, int n) {
        return binarySearch(arr, 0, arr.length - 1, n);
    }
}
