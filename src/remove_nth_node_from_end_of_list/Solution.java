package remove_nth_node_from_end_of_list;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int c = 0;
        ListNode temp = head;

        while (temp != null) {
            ++c;
            temp = temp.next;
        }

        int t = c - n + 1;
        temp = head;
        c = 0;

        if (t == 1) {
            head = head.next;
        } else {
            while (c < t - 2) {
                ++c;
                temp = temp.next;
            }


            temp.next = temp.next.next;
        }

        return head;
    }
}