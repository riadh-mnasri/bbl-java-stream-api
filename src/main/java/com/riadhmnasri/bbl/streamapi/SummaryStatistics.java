package com.riadhmnasri.bbl.streamapi;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummaryStatistics {
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("Amelie", "Paris", 28),
            new Person("Sebastien", "Montreuil", 35),
            new Person("Mohamed", "Paris", 33),
            new Person("Stephane", "Courbevoie", 42),
            new Person("Louise", "Paris", 27)
        );
        IntSummaryStatistics ageSummary =
            persons
                .stream()
                .collect(Collectors.summarizingInt(p -> p.getAge()));

        System.out.println(ageSummary);
    }
}
