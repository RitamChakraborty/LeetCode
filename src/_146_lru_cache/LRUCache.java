package _146_lru_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Use a doubly ended linked list to link the element. Add elements is stored in the HashMap as Nodes
 */
class LRUCache {
    class Node {
        int key;
        int value;
        Node previous;
        Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        addAtFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addAtFirst(node);
        } else {
            Node node = new Node(key, value);

            if (map.size() == capacity) {
                Node last = tail.previous;
                map.remove(last.key);
                remove(last);
            }

            map.put(key, node);
            addAtFirst(node);
        }
    }

    void addAtFirst(Node node) {
        node.next = head.next;
        node.previous = head;

        node.next.previous = node;
        head.next = node;
    }

    void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}
