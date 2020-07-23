package com.riadhmnasri.bbl.streamapi;

import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        Stream stream = Stream.generate(() -> new Random().nextInt(1000)).limit(5);
        stream.forEach(System.out::println);
    }
}
