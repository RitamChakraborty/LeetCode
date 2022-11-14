package _31_next_permutation;

/**
 * First find the peak
 * that is from right to left arr[i] < arr[i + 1]
 * store it to an index1
 * now again from right to left find the number which is greater than peak
 * that must be the start of the next permutation which is arr[i] > arr[index1]
 * store it in index2
 * swap(index1, index2)
 * now all the number right to index1 must be reversed
 * if index1 not found just reverse the array
 */
class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int ind1 = -1;

        for (int i = n - 2; i >= 0; --i) {
            if (arr[i] < arr[i + 1]) {
                ind1 = i;
                break;
            }
        }

        if (ind1 != -1) {
            int ind2 = n - 1;

            for (int i = ind2; i > ind1; --i) {
                if (arr[i] > arr[ind1]) {
                    ind2 = i;
                    break;
                }
            }

            int temp = arr[ind1];
            arr[ind1] = arr[ind2];
            arr[ind2] = temp;
        }

        int start = ind1 == -1 ? 0 : ind1 + 1;
        int end = n - 1;

        while (start < end) {
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            ++start;
            --end;
        }
    }
}