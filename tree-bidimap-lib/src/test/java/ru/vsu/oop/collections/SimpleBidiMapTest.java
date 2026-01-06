package ru.vsu.oop.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleBidiMapTest {

    @Test
    void putAndGetBothWays() {
        SimpleBidiMap<String, Integer> map = new SimpleBidiMap<>();
        map.put("a", 1);
        map.put("b", 2);

        assertEquals(1, map.getByKey("a"));
        assertEquals("b", map.getByValue(2));
    }

    @Test
    void valueIsUnique() {
        SimpleBidiMap<String, Integer> map = new SimpleBidiMap<>();
        map.put("a", 1);
        map.put("b", 1);

        assertNull(map.getByKey("a"));
        assertEquals(1, map.getByKey("b"));
        assertEquals("b", map.getByValue(1));
        assertEquals(1, map.size());
    }

    @Test
    void removeWorks() {
        SimpleBidiMap<String, Integer> map = new SimpleBidiMap<>();
        map.put("x", 10);

        assertEquals(10, map.removeByKey("x"));
        assertNull(map.getByValue(10));
        assertEquals(0, map.size());
    }
}
