package com.riadhmnasri.bbl.streamapi;

import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<String> colleagues = List.of("Sebastien", "Mohamed", "Amelie", "Louise", "Stephane");
        Optional<String> result = colleagues.stream().reduce( (c1, c2) -> c1 +  "#" + c2 );
        result.ifPresent(System.out::println);
    }
}
