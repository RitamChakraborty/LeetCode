package _1042_flower_planting_with_no_adjacent;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean possibleToColor(int node, int color, List<List<Integer>> edges, int[] colored) {
        List<Integer> neighbours = edges.get(node);
        for (int neighbour : neighbours) if (colored[neighbour] == color) return false;
        return true;
    }

    private boolean color(int node, int color, int colors, int nodes, List<List<Integer>> edges, int[] colored) {
        colored[node] = color;
        if (node == nodes - 1) return true;

        for (int c = 1; c <= colors; ++c) {
            if (!possibleToColor(node + 1, c, edges, colored)) continue;
            boolean result = color(node + 1, c, colors, nodes, edges, colored);
            if (result) return true;
        }

        colored[node] = 0;
        return false;
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; ++i) edges.add(new ArrayList<>());
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        int[] colored = new int[n];
        color(0, 1, 4, n, edges, colored);
        return colored;
    }
}
