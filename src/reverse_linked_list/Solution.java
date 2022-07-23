package reverse_linked_list;

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

//class Solution {
//    private List<ListNode> reverse(ListNode node, ListNode prev) {
//        if (node == null) {
//            return new ArrayList<>(Arrays.asList(null));
//        }
//
//        if (node.next == null) {
//            if (prev != null) {
//                prev.next = null;
//            }
//
//            node.next = prev;
//            return new ArrayList<>(Arrays.asList(node, node.next));
//        }
//
//        List<ListNode> list = reverse(node.next, node);
//        ListNode last = list.get(1);
//        last.next = prev;
//
//        if (prev != null) {
//            last.next.next = null;
//        }
//
//        list.set(1, last.next);
//        return list;
//    }
//
//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        return reverse(head, null).get(0);
//    }
//}

class Solution {
    public ListNode reverseList(ListNode head) {
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
}