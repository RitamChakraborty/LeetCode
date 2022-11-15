import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    private static void permutation(
            int index,
            int[] arr,
            boolean[] visited,
            Stack<Integer> stack,
            List<List<Integer>> list
    ) {
        int n = arr.length;

        if (index == n) {
            list.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                stack.push(arr[i]);
                visited[i] = true;
                permutation(index + 1, arr, visited, stack, list);
                stack.pop();
                visited[i] = false;
            }
        }
    }

    private static List<List<Integer>> permutation(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        permutation(0, arr, visited, stack, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(permutation(new int[]{1, 2, 3}));
    }
}
