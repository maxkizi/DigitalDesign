package ru.maxkizi.javapractice.exceptions;

public class NotLatinLettersException extends UnpackingException {
    public NotLatinLettersException(){
        super("There is cyrillic symbol in input string");
    }
}
