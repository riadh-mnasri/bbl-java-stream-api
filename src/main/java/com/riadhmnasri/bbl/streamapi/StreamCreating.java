package com.riadhmnasri.bbl.streamapi;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreating {
    public static void main(String[] args) {
        // 1st Manner
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ints.forEach(System.out::println);

        // 2nd Manner
        List<Integer> ints2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
       ints2.stream().forEach(System.out::println);

       // Int Stream
        IntStream intStream = "gfftggsv6676".chars();
        intStream.forEach(System.out::println);
    }
}
