package com.riadhmnasri.bbl.streamapi.map;

import java.util.List;
import java.util.stream.Collectors;

public class Transforming {

    public static void main(String[] args) {

        List<String> languages = List.of("Java", "Kotlin", "Javascript");

        languages.stream().map(l -> getLangugageType(l))
            .map(l -> l.toUpperCase())
            .peek(System.out::println)
            .collect(Collectors.toList());
    }

    static String getLangugageType(String langugage) {
        String type = "";
        switch (langugage) {
            case "Java":
                type = "Poo";
                break;
            case "Kotlin":
                type = "Poo/FP";
                break;

            case "Javascript":
                type = "Prototype/FP";
                break;
        }
        return type;
    }
}
