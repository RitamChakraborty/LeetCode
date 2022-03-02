package pascals_triangle_ii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= numRows; ++i) {
            List<Integer> l = new ArrayList<>();

            if (i == 0) {
                l.add(1);
            } else {
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        l.add(1);
                    } else {
                        List<Integer> pre = list.get(i - 1);
                        l.add(pre.get(j - 1) + pre.get(j));
                    }
                }
            }

            list.add(l);

            if (i == numRows) {
                return l;
            }
        }

        return null;
    }
}