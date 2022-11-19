package _203_remove_linked_list_elements;

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode node = fakeHead;

        while (node.next != null) {
            if (node.next.val == val) node.next = node.next.next;
            else node = node.next;
        }

        return fakeHead.next;
    }
}

class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}