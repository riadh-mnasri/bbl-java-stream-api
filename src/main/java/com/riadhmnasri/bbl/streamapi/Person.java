package com.riadhmnasri.bbl.streamapi;

public class Person {

    private String name;
    private String city;

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            '}';
    }

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
