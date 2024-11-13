package _116_populating_next_right_pointer_in_each_node;


import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    /* -> Solution 1
     private void traverse(Node node, Map<Integer, List<Node>> map, int level) {
         if (node != null) {
             if (!map.containsKey(level)) {
                 map.put(level, new ArrayList<>());
             }

             map.get(level).add(node);

             traverse(node.left, map, level + 1);
             traverse(node.right, map, level + 1);
         }
     }

     public Node connect(Node root) {
         Map<Integer, List<Node>> map = new HashMap<>();
         traverse(root, map, 0);

         for (int i : map.keySet()) {
             List<Node> nodes = map.get(i);
             for (int j = nodes.size() - 2; j >= 0; --j) {
                 nodes.get(j).next = nodes.get(j + 1);
             }
         }

         return root;
     }
     */

    /* -> Solution 2
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = null;
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                Node n = queue.peek();

                if (n != null) {
                    if (current != null) current.next = n;
                    current = n;
                    if (n.left != null) queue.add(n.left);
                    if (n.right != null) queue.add(n.right);
                }

                queue.poll();
            }
        }

        return root;
    }
     */

    private void traverse(Node node, Map<Integer, Node> map, int level) {
        if (node != null) {
            if (map.containsKey(level)) map.get(level).next = node;
            map.put(level, node);
            traverse(node.left, map, level + 1);
            traverse(node.right, map, level + 1);
        }
    }

    public Node connect(Node root) {
        Map<Integer, Node> map = new HashMap<>();
        traverse(root, map, 0);
        return root;
    }
}