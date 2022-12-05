package _60_permutation_sequence;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int factorial(int n) {
        if (n == 0) return 1;
        int fact = 1;
        for (int i = 1; i <= n; ++i) fact *= i;
        return fact;
    }

    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) list.add(i);
        k--;
        n--;
        int fact = factorial(n);

        while (n != 0) {
            int index = k / fact;
            stringBuilder.append(list.get(index));
            int ignore = list.remove(index);
            k %= fact;
            fact /= n;
            n--;
        }

        return stringBuilder.toString();
    }
}
