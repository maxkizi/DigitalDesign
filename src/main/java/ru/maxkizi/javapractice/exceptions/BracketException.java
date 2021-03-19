package ru.maxkizi.javapractice.exceptions;

public class BracketException extends UnpackingException {
    public BracketException(){
        super("There isn't bracket between digit and literal");
    }
}
