package com.tuan.exercise.java8.util;

import java.util.List;
import java.util.Map;

public class Printer {
    private Printer() {
    }

    public static <K, V> void printMap(Map<K, V> map) {

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        map.forEach(
                (key, value) -> 
                sb.append(key).append(" : ").append(value).append("\n")
                .append("---------------\n")
        );
        sb.append("}");

        Log.info(sb.toString());
    }

    public static <E> void printList(List<E> list) {
        list.forEach(elem -> Log.info(elem.toString()));
    }
}
