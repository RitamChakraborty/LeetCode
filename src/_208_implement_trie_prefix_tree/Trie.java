package _208_implement_trie_prefix_tree;

class Trie {
    private static class Node {
        Node[] ref = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return ref[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            ref[ch - 'a'] = node;
        }

        Node get(char ch) {
            return ref[ch - 'a'];
        }

        void setFlag() {
            flag = true;
        }

        boolean isFlagSet() {
            return flag;
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }

        node.setFlag();
    }

    public boolean search(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }

        return node.isFlagSet();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }

        return true;
    }
}