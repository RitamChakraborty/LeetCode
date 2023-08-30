package _2_add_two_numbers;

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
        ListNode fakeHead = new ListNode();
        ListNode tmp = fakeHead;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int total = l1.val + l2.val + carry;
            int val = total % 10;
            carry = total / 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int total = l1.val + carry;
            int val = total % 10;
            carry = total / 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int total = l2.val + carry;
            int val = total % 10;
            carry = total / 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }

        return fakeHead.next;
    }
}