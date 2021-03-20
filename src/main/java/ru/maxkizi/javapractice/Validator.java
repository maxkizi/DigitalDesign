package ru.maxkizi.javapractice;

import ru.maxkizi.javapractice.exceptions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private String inboundString;

    public Validator(String inboundString) {
        this.inboundString = inboundString;
    }

    public void fullValidation() throws MyValidationException {
        digitBracketValidation();
        doubleBracketValidation();
        spaceValidation();
        latinLettersValidation();
    }

    public void digitBracketValidation() throws BracketException {
        if (this.inboundString.matches("\\w+"))
            return;
        Pattern pattern = Pattern.compile("(\\d)+[A-Za-z]");
        Matcher matcher = pattern.matcher(this.inboundString);
        if (matcher.find()) {
            throw new BracketException();
        }
    }

    public void doubleBracketValidation() throws DoubleBracketException {
        String openBracketReg = "\\[";
        String closeBracketReg = "\\]";

        int openedBracketsCount = 0;
        int closedBracketsCount = 0;

        Pattern pattern1 = Pattern.compile(openBracketReg);
        Matcher matcher1 = pattern1.matcher(inboundString);
        while (matcher1.find()) {
            openedBracketsCount++;
        }

        Pattern pattern2 = Pattern.compile(closeBracketReg);
        Matcher matcher2 = pattern2.matcher(inboundString);
        while (matcher2.find()) {
            closedBracketsCount++;
        }
        if (!(closedBracketsCount == openedBracketsCount)) {
            throw new DoubleBracketException();
        }
    }

    public void spaceValidation() throws SpaceException {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(this.inboundString);

        if (matcher.find()) {
            throw new SpaceException();
        }
    }

    public void latinLettersValidation() throws NotLatinLettersException {

        String s1 = "";
        String s2 = "";
        String s3 = "";

        Pattern pattern = Pattern.compile("[^A-Za-z]");
        Matcher matcher = pattern.matcher(this.inboundString);
        while (matcher.find()) {
            s1 += (matcher.group());
        }

        pattern = Pattern.compile("[^\\d]");
        matcher = pattern.matcher(s1);
        while (matcher.find()) {
            s2 += (matcher.group());
        }


        pattern = Pattern.compile("(\\[|])*");
        matcher = pattern.matcher(s2);
        while (matcher.find()) {
            s3 = matcher.replaceAll("");
        }
        if (s3.length() != 0) {
            throw new NotLatinLettersException();
        }
    }


}
