package _118_pascals_triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>(Collections.singletonList(1));
        result.add(prev);

        for (int i = 1; i < n; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            for (int j = 1; j < prev.size(); ++j) {
                int value = prev.get(j - 1) + prev.get(j);
                list.add(value);
            }

            list.add(1);
            prev = list;
            result.add(prev);
        }

        return result;
    }
}