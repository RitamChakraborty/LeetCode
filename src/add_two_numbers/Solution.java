package add_two_numbers;

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

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        ListNode l1Prev = null;

        while (l1 != null && l2 != null) {
            int value = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1.val = value;
            l1Prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l1Prev != null) {
            l1Prev.next = l2;
            l1 = l2;
        }

        while (l1 != null) {
            int value = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1.val = value;
            l1Prev = l1;
            l1 = l1.next;
        }

        if (carry != 0) {
            l1Prev.next = new ListNode(carry);
        }

        return head;
    }
}