package ru.vsu.oop.collections;

import java.util.ArrayList;
import java.util.List;

public class MyTreeMap<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int size;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return findNode(key) != null;
    }

    public V get(K key) {
        Node<K, V> n = findNode(key);
        return (n == null) ? null : n.value;
    }


    public V put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            size++;
            return null;
        }

        Node<K, V> cur = root;

        while (true) {
            int cmp = key.compareTo(cur.key);

            if (cmp == 0) {
                V old = cur.value;
                cur.value = value;
                return old;
            } else if (cmp < 0) {
                if (cur.left == null) {
                    cur.left = new Node<>(key, value);
                    size++;
                    return null;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Node<>(key, value);
                    size++;
                    return null;
                }
                cur = cur.right;
            }
        }
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> cur = root;
        while (cur != null) {
            int cmp = key.compareTo(cur.key);
            if (cmp == 0) return cur;
            if (cmp < 0) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }

}