package _1046_last_stone_weight;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Max Heap: Keep removing stones until one element or empty
 * Time: O(N * LogN)
 * Space: O(N)
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();

            if (x < y) {
                queue.offer(y - x);
            }
        }

        return queue.isEmpty() ? 0 : queue.element();
    }
}
