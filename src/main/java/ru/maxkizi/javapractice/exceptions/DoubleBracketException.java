package ru.maxkizi.javapractice.exceptions;

public class DoubleBracketException extends MyValidationException {
    public DoubleBracketException(){
        super("There isn't opened/closed bracket");
    }
}
