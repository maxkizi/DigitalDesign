package ru.maxkizi.javapractice;

import ru.maxkizi.javapractice.exceptions.DoubleBracketException;
import ru.maxkizi.javapractice.exceptions.NotLatinLettersException;
import ru.maxkizi.javapractice.exceptions.UnpackingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private String inboundString;

    public Validator(String inboundString){
        this.inboundString = inboundString;
    }

    public void fullValidation(String string) throws UnpackingException {
       doubleBracketValidation(string);
       latinLettersValidation(string);
       spaceValidation(string);
       digitBracketValidation(string);
    }

    public void digitBracketValidation(String string) {
    }

    public void spaceValidation(String string) {
    }

    public void latinLettersValidation(String string) throws NotLatinLettersException {
        if(!(string.matches(".*(\\w+)+.*"))){
            throw new NotLatinLettersException();
        }
    }

    public void doubleBracketValidation(String string) throws DoubleBracketException {
        String openBracketReg = "\\[";
        String closeBracketReg = "\\]";

        int openedBracketsCount = 0;
        int closedBracketsCount = 0;

        Pattern pattern1 = Pattern.compile(openBracketReg);
        Matcher matcher1 = pattern1.matcher(string);
        while (matcher1.find()) {
            openedBracketsCount++;
        }

        Pattern pattern2 = Pattern.compile(closeBracketReg);
        Matcher matcher2 = pattern2.matcher(string);
        while (matcher2.find()) {
            closedBracketsCount++;
        }
        if (!(closeBracketReg==openBracketReg)){
            throw new DoubleBracketException();
        }
    }
}
