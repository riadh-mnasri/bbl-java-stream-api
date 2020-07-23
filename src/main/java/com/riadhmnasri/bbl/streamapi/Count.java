package com.riadhmnasri.bbl.streamapi;

import java.util.List;

public class Count {
    public static void main(String[] args) {

        List<String> words = List.of("Java", "Kotlin", "Javascript");
        Long count = words.stream()
            .filter(word -> word.startsWith("J"))
            .count();
        System.out.println(count);

    }
}
