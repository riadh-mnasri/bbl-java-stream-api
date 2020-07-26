package com.riadhmnasri.bbl.streamapi;

import com.riadhmnasri.bbl.streamapi.model.Developer;
import com.riadhmnasri.bbl.streamapi.model.Language;
import com.riadhmnasri.bbl.streamapi.model.Person;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiveCoding {

    public static void main(String[] args) {
        // 1. Stream creating
        Stream<Integer> intsStream = Stream.of(3, 8, 9, 7, 5);
        intsStream.forEach(System.out::println);

        List<Integer> ints = List.of(3, 8, 9, 7, 5);
        ints.stream().forEach(System.out::println);

        // 2. Infinite Streams
        Stream.generate(() -> new Random().nextInt(1000)).limit(5)
            .forEach(System.out::println);

        // 3. Transforming
        // Given Data
        List<String> languages = List.of("Java", "Kotlin", "Javascript");
        // Show these languages types in uppercase
        languages.stream()
            .map(LiveCoding::getLangugageType)
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // 4. FlatMap
        // Given Data
        List<Developer> developers = List.of(
            new Developer("Stephane",
                List.of(new Language("Java"), new Language("Kotlin"), new Language("Javascript"))),

            new Developer("Mohamed",
                List.of(new Language("Kotlin"), new Language("Rust"))),

            new Developer("Louise",
                List.of(new Language("Scala"), new Language("Python")))
        );

        // Show team languages without duplicate and written in uppercase

        List<String> teamLanguages = developers.stream()
            .flatMap(d -> d.getLanguages().stream())
            .map(l -> l.getName())
            .map(l -> l.toUpperCase())
            .distinct()
            .collect(Collectors.toList());
        System.out.println(teamLanguages);

        // 5. Filtering
        // Show languages starting with "J"
        List<String> languagesStartingWithJ = languages.stream().filter(LiveCoding::isStartingWithJ).collect(Collectors.toList());
        System.out.println(languagesStartingWithJ);

        // 6. Counting
        // Count languages starting with "J"
        Long numberOfLanguageStartingWithJ = languages.stream().filter(LiveCoding::isStartingWithJ).count();
        System.out.println(numberOfLanguageStartingWithJ);

        // 7. Joining

        List<Person> persons = List.of(
            new Person("Sebastien", "Montreuil", 15),
            new Person("Mohamed", "Paris", 19),
            new Person("Amelie", "Paris", 28),
            new Person("Louise", "Paris", 16),
            new Person("Stephane", "Courbevoie", 22)
        );

        // Show in one String the list of person having the legal age in france
        // delimiter = " and " prefix= "In Fance ", suffix=" are of legal age."
        String result = persons.stream().filter(p -> p.getAge() >= 18)
            .map(Person::getName)
            .collect(Collectors.joining(" and ", "In France ", " are of legal age."));
        System.out.println(result);


        // 8. Average
        // Show the average of the persons list above
        Double averageAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println(averageAge);

        // 9. Statistics
        // Show the standard statistics of the persons list above
        IntSummaryStatistics ageSummary = persons.stream()
                                                  .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println(ageSummary);

        // 10. Reducing
        // Show in one string with separator "#" the list of names of the persons list above
        Optional<String> personsNames = persons.stream()
            .map(Person::getName)
            .reduce((n1, n2) -> n1 + "#" + n2);
        personsNames.ifPresent(System.out::println);

        // 11. Grouping
        // Show the number of persons by city
        Map<String, Long> numberOfpersonsByCity = persons.stream()
            .collect(Collectors.groupingBy(p -> p.getCity(), Collectors.counting()));
        System.out.println(numberOfpersonsByCity);

        // 12. Partitioning
        // partition the persons by the legal age
        Map<Boolean, List<Person>> partitions = persons.stream()
                                                        .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
        System.out.println(partitions);

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

    private static boolean isStartingWithJ(String languageName) {
        return languageName.startsWith("J");
    }
}
