package _160_intersection_of_two_linked_list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode list1 = headA;
        ListNode list2 = headB;

        while (list1 != list2) {
            list1 = list1 == null ? headB : list1.next;
            list2 = list2 == null ? headA : list2.next;
        }

        return list1;
    }
}

/**
 * Two pointers: Find out which list is larger and by how much and start by that count ahead for the larger list
 * Time: O(M + N)
 * Space: O(1)
 */
class SolutionOptimized {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        ListNode tempA = headA;

        // count tempB
        while (tempA != null) {
            tempA = tempA.next;
            countA++;
        }

        int countB = 0;
        ListNode tempB = headB;

        while (tempB != null) {
            tempB = tempB.next;
            countB++;
        }

        boolean aIsLarger = countA > countB;
        ListNode temp = aIsLarger ? headA : headB;
        int count = 0;

        while (count != Math.abs(countA - countB)) {
            temp = temp.next;
            count++;
        }

        tempA = aIsLarger ? temp : headA;
        tempB = aIsLarger ? headB : temp;

        while (tempA != null && tempB != null && tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}