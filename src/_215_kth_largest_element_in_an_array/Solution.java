package _215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Max Heap: If the size of the queue is greater than k then poll
 * Time: O(N * LogN)
 * Space: O(K)
 */
class SolutionMaxHeap {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : nums) {
            queue.offer(i);
            if (queue.size() > k) queue.poll();
        }

        return queue.element();
    }
}
