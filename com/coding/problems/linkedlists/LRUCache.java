package com.coding.problems.linkedlists;

import java.util.HashMap;

class CacheNode {
    int key, value;
    CacheNode next, prev;

    CacheNode() {}

    CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    int capacity, size;
    private CacheNode head = new CacheNode();
    private CacheNode tail = new CacheNode();
    private HashMap<Integer, CacheNode> cache = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        CacheNode node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            CacheNode node = new CacheNode(key, value);
            cache.put(key, node);
            addToHead(node);
            if(++size > capacity) {
                node = tail.prev;
                cache.remove(node.key);
                removeNode(node);
                --size;
            }
        }
    }

    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(CacheNode node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}

