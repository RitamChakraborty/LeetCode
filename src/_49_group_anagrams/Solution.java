package _49_group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = new char[26];

            for (char ch : s.toCharArray()) {
                arr[ch - 97]++;
            }

            String key = new String(arr);

            if (map.containsKey(key)) map.get(key).add(s);
            else map.put(key, new ArrayList<>(List.of(s)));
        }

        return new ArrayList<>(map.values());
    }
}