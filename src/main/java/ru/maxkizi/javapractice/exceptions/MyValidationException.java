package ru.maxkizi.javapractice.exceptions;

public class MyValidationException extends Throwable {
    MyValidationException(String message){
        super(message);
    }
}
