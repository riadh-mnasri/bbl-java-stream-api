package com.riadhmnasri.bbl.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Average {
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("Sebastien", "Montreuil", 35),
            new Person("Mohamed", "Paris", 33),
            new Person("Amelie", "Paris", 28),
            new Person("Louise", "Paris", 27),
            new Person("Stephane", "Courbevoie",  42)
        );

        Double averageAge = persons
            .stream()
            .collect(Collectors.averagingInt(Person::getAge));

        System.out.println(averageAge);
    }
}
