package com.riadhmnasri.bbl.streamapi.model;

import java.util.List;

public class Developer {

    private String name;
    private List<Language> languages;

    public Developer(String name, List<Language> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Developer{" +
            "name='" + name + '\'' +
            '}';
    }
}
