package ru.maxkizi.javapractice.exceptions;

public class BracketException extends MyValidationException {
    public BracketException(){
        super("There isn't bracket between digit and literal");
    }
}
