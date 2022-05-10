package com.exer.project3.domain;

public class Printer implements Equipment {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Printer() {
    }

    private String type;

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
