package ru.maxkizi.javapractice.exceptions;

public class SpaceException extends MyValidationException{
    public SpaceException() {
        super("There is space in input String");
    }
}
