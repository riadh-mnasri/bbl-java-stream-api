package com.riadhmnasri.bbl.streamapi.flatmap;

import java.util.List;
import java.util.stream.Collectors;

public class Flatmap {

    public static void main(String[] args) {
        List<Developer> developers = List.of(
            new Developer("Stephane",
                List.of(new Language("Java"), new Language("Kotlin"), new Language("Javascript"))),

            new Developer("Mohamed",
                List.of(new Language("Kotlin"), new Language("Rust"))),

            new Developer("Louise",
                List.of(new Language("Scala"), new Language("Python")))
        );

        List<String> teamLanguages = developers.stream().
            map(d -> d.getLanguages()).
            flatMap(l -> l.stream()).
            map(l -> l.getName()).
            collect(Collectors.toList());

        System.out.println(teamLanguages);
    }

}
