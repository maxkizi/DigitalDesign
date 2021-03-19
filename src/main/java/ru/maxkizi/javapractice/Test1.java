package ru.maxkizi.javapractice;

import ru.maxkizi.javapractice.exceptions.BracketException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws BracketException {
        Validator validator = new Validator("12[a2[b]]");
        validator.digitBracketValidation();

    }

}
