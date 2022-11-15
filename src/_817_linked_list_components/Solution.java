package _817_linked_list_components;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        while (head != null) {
            if (set.contains(head.val)) {
                ++count;
                while (head != null && set.contains(head.val)) head = head.next;
            } else {
                head = head.next;
            }
        }

        return count;
    }
}