package _19_remove_nth_node_from_end_of_list;

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

/**
 * Two pointers:
 * Let the fast pointer goes till n. After that move the slow and fast pointer together till fast reaches the end.
 * That'll also be the point where you have to remove the element from slow. Use fake head.
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode fast = fakeHead;
        ListNode slow = fakeHead;

        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return fakeHead.next;
    }
}