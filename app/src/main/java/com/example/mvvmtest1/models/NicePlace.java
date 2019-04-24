package com.example.mvvmtest1.models;

import java.io.Serializable;

public class NicePlace implements Serializable {

    public String name;
    public String description;

    public NicePlace() {
    }

    public NicePlace(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @Override
    public String toString() {
        return name + " : " + description;
    }
}
