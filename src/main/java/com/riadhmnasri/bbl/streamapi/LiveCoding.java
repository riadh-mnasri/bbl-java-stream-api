package com.riadhmnasri.bbl.streamapi;

import com.riadhmnasri.bbl.streamapi.model.Developer;
import com.riadhmnasri.bbl.streamapi.model.Language;
import com.riadhmnasri.bbl.streamapi.model.Person;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiveCoding {

    public static void main(String[] args) {
        // 1. Stream creating
        // from stream
        Stream<Integer> ints = Stream.of(1, 5, 6, 9);
        ints.forEach(System.out::println);

        // from list


        // 2. Infinite Streams
        // Infinite random numbers
        Stream.generate(() -> 1).peek(System.out::println).limit(10).collect(Collectors.toList());
        // 3. Transforming
        // Given Data
        List<String> languages = List.of("Java", "Kotlin", "Javascript");
        // Show these languages types in uppercase
        List<String> result = languages.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);

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
        developers.stream().flatMap(d -> d.getLanguages().stream())
            .map(l -> l.getName())
            .map(n -> n.toUpperCase())
            .distinct()
            .peek(System.out::println)
            .collect(Collectors.toList());

        // 5. Filtering
        // Show languages starting with "J"

        List<String> languagesStartingWithJ = languages.stream().filter(LiveCoding::isStartingWithJ).collect(Collectors.toList());
        System.out.println(languagesStartingWithJ);
        // 6. Counting
        // Count languages starting with "J"
        Long numberOflanguagesStartingWithJ = languages.stream().filter(LiveCoding::isStartingWithJ).count();
        System.out.println(numberOflanguagesStartingWithJ);
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
        String personsHavingLegalAgeInFrance = persons.stream()
            .filter(p -> p.getAge() >= 18)
            .map(p -> p.getName())
            .collect(Collectors.joining(" , ", "In France ", " are of legal age."));
        System.out.println(personsHavingLegalAgeInFrance);


        // 8. Average
        // Show the average of the persons list above
        Double averageAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println(averageAge);
        // 9. Statistics
        // Show the standard statistics of the persons list above:  IntSummaryStatistics

        IntSummaryStatistics statistics = persons.stream().collect(Collectors.summarizingInt(Person::getAge));
        System.out.println(statistics);
        // 10. Reducing
        // Show in one string with separator "#" the list of names of the persons list above
        Optional<String> personsNames = persons.stream().map(Person::getName).reduce((name1, name2) -> name1.concat("#").concat(name2));
        personsNames.ifPresent(System.out::println);


        // 11. Grouping
        // Show the number of persons by city
        Map<String, Long> res = persons.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        System.out.println(res);

        // 12. Partitioning
        // partition the persons by the legal age
        Map<Boolean, List<Person>> partitions = persons.stream()
                                         .collect(Collectors.partitioningBy(p -> p.getAge()>=18));
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
