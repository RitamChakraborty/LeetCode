package middle_of_the_linked_list;

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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode n1 = head;
        ListNode n2 = head;

        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        return n1;
    }
}
