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
        // from stream

        // from list

        // 2. Infinite Streams
        // Infinite random numbers

        // 3. Transforming
        // Given Data
        List<String> languages = List.of("Java", "Kotlin", "Javascript");
        // Show these languages types in uppercase

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

        // 5. Filtering
        // Show languages starting with "J"

        // 6. Counting
        // Count languages starting with "J"


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


        // 8. Average
        // Show the average of the persons list above


        // 9. Statistics
        // Show the standard statistics of the persons list above:  IntSummaryStatistics


        // 10. Reducing
        // Show in one string with separator "#" the list of names of the persons list above


        // 11. Grouping
        // Show the number of persons by city


        // 12. Partitioning
        // partition the persons by the legal age


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
