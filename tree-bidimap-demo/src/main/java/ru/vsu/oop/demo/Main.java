package ru.vsu.oop.demo;

import ru.vsu.oop.collections.MyTreeMap;
import ru.vsu.oop.collections.SimpleBidiMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== MyTreeMap demo ===");
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(5, "five");
        map.put(2, "two");
        map.put(7, "seven");
        map.put(1, "one");

        System.out.println("size = " + map.size());
        System.out.println("get(2) = " + map.get(2));
        System.out.println("keys in order = " + map.keysInOrder());

        System.out.println("remove(2) = " + map.remove(2));
        System.out.println("keys in order = " + map.keysInOrder());

        System.out.println();
        System.out.println("=== SimpleBidiMap demo ===");
        SimpleBidiMap<String, Integer> bidi = new SimpleBidiMap<>();
        bidi.put("one", 1);
        bidi.put("two", 2);
        bidi.put("three", 3);

        System.out.println("by key 'two' = " + bidi.getByKey("two"));
        System.out.println("by value 3 = " + bidi.getByValue(3));

        // покажем уникальность значений
        bidi.put("TWO", 2);
        System.out.println("after put('TWO', 2):");
        System.out.println("by key 'two' = " + bidi.getByKey("two"));
        System.out.println("by key 'TWO' = " + bidi.getByKey("TWO"));
        System.out.println("by value 2 = " + bidi.getByValue(2));
    }
}