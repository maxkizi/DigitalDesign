package ru.maxkizi.javapractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String input = "4[vzn]2[z]zqw";
        String regex = ".*\\w+.*";

        System.out.println(input.matches(regex));
    }
}

