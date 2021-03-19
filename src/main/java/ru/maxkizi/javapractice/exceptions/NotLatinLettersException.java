package ru.maxkizi.javapractice.exceptions;

public class NotLatinLettersException extends MyValidationException {
    public NotLatinLettersException(){
        super("There is not latin symbol in input string");
    }
}
