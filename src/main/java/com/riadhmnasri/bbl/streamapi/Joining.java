package com.riadhmnasri.bbl.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Joining {
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("Sebastien", "Montreuil", 15),
            new Person("Mohamed", "Paris", 19),
            new Person("Amelie", "Paris", 28),
            new Person("Louise", "Paris", 16),
            new Person("Stephane", "Courbevoie",  22)
        );

        String phrase = persons
            .stream()
            .filter(p -> p.getAge() >= 18)
            .map(p -> p.getName())
            .collect(Collectors.joining(" and ", "In Fance ", " are of legal age."));

        System.out.println(phrase);
    }
}
