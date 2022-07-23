package palindrome_linked_list;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

class Solution {
    private ListNode middleNext(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;

        while (node2 != null) {
            if (node2.next != null) {
                node2 = node2.next.next;
            } else {
                node2 = null;
            }
            node1 = node1.next;
        }

        return node1;
    }

    private ListNode reverse(ListNode head) {
        ListNode tempHead = new ListNode(-1);
        ListNode temp = head;

        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = tempHead.next;
            tempHead.next = temp;
            temp = nextNode;
        }

        return tempHead.next;
    }

    private void print(ListNode node) {
        ArrayList<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        System.out.println(list);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode reversed = reverse(middleNext(head));

        while (reversed != null) {
            if (head == null || reversed.val != head.val) {
                return false;
            }

            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }
}