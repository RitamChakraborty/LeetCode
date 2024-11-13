package _547_number_of_provinces;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static class Node {
        int value;
        List<Node> neighbors;

        Node(int value, List<Node> neighbors) {
            this.value = value;
            this.neighbors = neighbors;
        }
    }

    private void traverse(Node node, boolean[] visited) {
        if (node != null && !visited[node.value]) {
            visited[node.value] = true;

            for (Node n : node.neighbors) {
                traverse(n, visited);
            }
        }
    }

    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        Node[] nodes = new Node[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i, new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (arr[i][j] != 0) {
                    nodes[i].neighbors.add(nodes[j]);
                    nodes[j].neighbors.add(nodes[i]);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                traverse(nodes[i], visited);
                ++count;
            }
        }

        return count;
    }
}
