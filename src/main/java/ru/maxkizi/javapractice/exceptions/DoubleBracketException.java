package ru.maxkizi.javapractice.exceptions;

public class DoubleBracketException extends UnpackingException {
    public DoubleBracketException(){
        super("There isn't opened/closed bracket");
    }
}
