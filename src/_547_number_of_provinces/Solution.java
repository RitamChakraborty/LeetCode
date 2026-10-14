package _547_number_of_provinces;

import java.util.ArrayList;
import java.util.List;

// Brute Force
class Solution1 {
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


/**
 * <b>Optimal</b>
 * 
 * Loop over the visited array and for the non visited nodes call the dfs to visit the neighbors
 */

class Solution2 {
    private void dfs(int index, int[][] arr, int[] visited, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int i = 0; i < n; i++) {
                if (arr[node][i] == 1 && visited[i] == 0) {
                    stack.push(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public int findCircleNum(int[][] arr) {
        int count = 0;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, arr, visited, n);
                count++;
            }
        }

        return count;
    }
}

/**
 * Use recursion instead of stack
 */
class Solution3 {
    private void dfs(int index, int[][] isConnected, boolean[] visited) {
        visited[index] = true;
        int n = isConnected.length;

        for (int j = 0; j < n; j++) {
            if (isConnected[index][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }
}