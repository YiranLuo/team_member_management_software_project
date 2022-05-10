package com.exer.project3.service;

/**
 * exception class
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -32442432325566L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
