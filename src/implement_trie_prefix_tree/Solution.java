package implement_trie_prefix_tree;

import java.util.HashMap;
import java.util.Map;

class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            temp = temp.addCharacter(ch);
        }

        temp.setEnd();
    }

    public boolean search(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            temp = temp.get(ch);

            if (temp == null) {
                return false;
            }
        }

        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;

        for (char ch : prefix.toCharArray()) {
            temp = temp.get(ch);

            if (temp == null) {
                return false;
            }
        }

        return true;
    }

    private static class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean isWord;

        public boolean containsCharacter(char ch) {
            return map.get(ch) != null;
        }

        public Node addCharacter(char ch) {
            if (map.get(ch) == null) {
                map.put(ch, new Node());
            }

            return map.get(ch);
        }

        public void setEnd() {
            isWord = true;
        }

        public Node get(char ch) {
            return map.get(ch);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("suki");
        trie.insert("shukti");
        trie.insert("sukitka");
        trie.insert("huktika");
        System.out.println(trie.search("suki"));
        System.out.println(trie.search("shuktika"));
        System.out.println(trie.startsWith("suk"));
        System.out.println(trie.startsWith("shuktik"));
    }
}
