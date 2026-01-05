package ru.vsu.oop.collections;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyTreeMapTest {

    @Test
    void putAndGetWorks() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(2, "two");
        map.put(1, "one");

        assertEquals("one", map.get(1));
        assertEquals("two", map.get(2));
        assertNull(map.get(3));
    }

    @Test
    void putReplacesValue() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        assertNull(map.put(5, "a"));
        assertEquals("a", map.put(5, "b"));
        assertEquals("b", map.get(5));
        assertEquals(1, map.size());
    }

    @Test
    void removeLeaf() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");

        assertEquals("one", map.remove(1));
        assertNull(map.get(1));
        assertEquals(2, map.size());
    }

    @Test
    void removeNodeWithOneChild() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(5, "five");
        map.put(3, "three");
        map.put(4, "four"); // у 3 один ребёнок справа

        assertEquals("three", map.remove(3));
        assertNull(map.get(3));
        assertEquals("four", map.get(4));
        assertEquals(2, map.size());
    }

    @Test
    void keysInOrderGivesSortedKeys() {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(5, "five");
        map.put(2, "two");
        map.put(7, "seven");
        map.put(1, "one");

        List<Integer> keys = map.keysInOrder();
        assertEquals(List.of(1, 2, 5, 7), keys);
    }
}