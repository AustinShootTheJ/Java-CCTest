package com.example.cctest;

public class Law {
    private final String name;
    private final String description;

    public Law(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString(){
        return this. name + " : " + this.description;
    }
}
