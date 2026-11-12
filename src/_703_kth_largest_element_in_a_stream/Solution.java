package _703_kth_largest_element_in_a_stream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Max Heap: If the size of the heap is greater than k, remove the highest
 * Time: O(N * logN)
 * Space: O(K)
 */
class KthLargest {
    private final Queue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();

        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        queue.offer(val);

        if (queue.size() > k) {
            queue.poll();
        }

        return queue.element();
    }
}
