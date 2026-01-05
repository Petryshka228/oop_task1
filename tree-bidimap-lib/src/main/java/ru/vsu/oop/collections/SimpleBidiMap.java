package ru.vsu.oop.collections;

import java.util.HashMap;
import java.util.Map;


public class SimpleBidiMap<K, V> {

    private final Map<K, V> forward = new HashMap<>();
    private final Map<V, K> backward = new HashMap<>();

    public int size() {
        return forward.size();
    }

    public V getByKey(K key) {
        return forward.get(key);
    }

    public K getByValue(V value) {
        return backward.get(value);
    }

    public boolean containsKey(K key) {
        return forward.containsKey(key);
    }

    public boolean containsValue(V value) {
        return backward.containsKey(value);
    }

    public V put(K key, V value) {
        // если у ключа было старое значение — чистим обратную связь
        V oldValue = forward.get(key);
        if (oldValue != null) {
            backward.remove(oldValue);
        }

        // если value уже занят другим ключом — удаляем тот ключ
        K oldKey = backward.get(value);
        if (oldKey != null) {
            forward.remove(oldKey);
        }

        forward.put(key, value);
        backward.put(value, key);

        return oldValue;
    }

    public V removeByKey(K key) {
        V val = forward.remove(key);
        if (val != null) {
            backward.remove(val);
        }
        return val;
    }

    public K removeByValue(V value) {
        K key = backward.remove(value);
        if (key != null) {
            forward.remove(key);
        }
        return key;
    }

    public void clear() {
        forward.clear();
        backward.clear();
    }
}