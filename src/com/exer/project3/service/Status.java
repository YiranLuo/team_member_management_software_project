package com.exer.project3.service;

public class Status {
    private final String NAME;
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    private Status(String name) {
        NAME = name;
    }

    public String getNAME() {
        return NAME;
    }
}
