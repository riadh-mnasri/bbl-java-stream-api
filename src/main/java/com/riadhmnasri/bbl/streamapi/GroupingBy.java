package com.riadhmnasri.bbl.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("Riadh", "Paris"),
            new Person("Stephane", "Montreuil"),
            new Person("Sebastien", "Paris")
        );

        Map<String, List<Person>> result = persons.stream()
                                                   .collect(Collectors.groupingBy(p -> p.getCity()));
        System.out.println(result);
    }
}
