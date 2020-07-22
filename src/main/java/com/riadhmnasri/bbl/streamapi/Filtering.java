package com.riadhmnasri.bbl.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    public static void main(String[] args) {
        List<String> words = List.of("Java", "Kotlin", "Javascript");
        List<String> filtered = words.stream().filter(word -> word.startsWith("J")).collect(Collectors.toList());
        System.out.println(filtered);
    }
}
