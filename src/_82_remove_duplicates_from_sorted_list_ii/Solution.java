package _82_remove_duplicates_from_sorted_list_ii;

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode node = fakeHead;

        while (node != null) {
            ListNode next = node.next;

            while (next != null && next.next != null && next.val == next.next.val) {
                int val = next.val;

                while (next != null && next.val == val) {
                    next = next.next;
                }
            }

            node.next = next;
            node = node.next;
        }

        return fakeHead.next;
    }
}

class Solution1 {
    private ListNode remove(ListNode node) {
        if (node == null) {
            return null;
        }

        int val = node.val;

        if (node.next != null && node.next.val == val) {
            while (node != null && node.val == val) {
                node = node.next;
            }

            return remove(node);
        }

        return node;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode node = fakeHead;

        while (node != null) {
            ListNode next = node.next;

            while (next != null && next.next != null && next.val == next.next.val) {
                int val = next.val;

                while (next != null && next.val == val) {
                    next = next.next;
                }
            }

            node.next = next;
            node = node.next;
        }

        return fakeHead.next;
    }
}
