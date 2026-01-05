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

    // Возвращает список ключей по возрастанию (inorder обход).

    public List<K> keysInOrder() {
        List<K> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(Node<K, V> node, List<K> out) {
        if (node == null) return;
        inorder(node.left, out);
        out.add(node.key);
        inorder(node.right, out);
    }

    public V remove(K key) {
        Box<V> old = new Box<>();
        root = removeRec(root, key, old);
        if (old.hasValue) {
            size--;
            return old.value;
        }
        return null;
    }

    private static class Box<V> {
        V value;
        boolean hasValue;
    }

    private Node<K, V> removeRec(Node<K, V> node, K key, Box<V> old) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = removeRec(node.left, key, old);
            return node;
        }
        if (cmp > 0) {
            node.right = removeRec(node.right, key, old);
            return node;
        }

        old.value = node.value;
        old.hasValue = true;

        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        Node<K, V> min = findMin(node.right);
        node.key = min.key;
        node.value = min.value;
        node.right = removeMin(node.right);
        return node;
    }

    private Node<K, V> findMin(Node<K, V> node) {
        Node<K, V> cur = node;
        while (cur.left != null) cur = cur.left;
        return cur;
    }

    private Node<K, V> removeMin(Node<K, V> node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return node;
    }

}