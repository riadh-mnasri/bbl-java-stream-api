package com.riadhmnasri.bbl.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("Amelie", "Paris", 28),
            new Person("Sebastien", "Montreuil", 35),
            new Person("Mohamed", "Paris", 33),
            new Person("Stephane", "Courbevoie",  42),
            new Person("Louise", "Paris", 27)
        );

        Map<String, List<Person>> result = persons.stream()
                                                   .collect(Collectors.groupingBy(Person::getCity));
        System.out.println(result);
    }
}
