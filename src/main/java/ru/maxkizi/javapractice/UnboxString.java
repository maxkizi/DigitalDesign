package ru.maxkizi.javapractice;

import ru.maxkizi.javapractice.exceptions.MyValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnboxString {

    public static final String REGEX_FOR_MULTIPLE = "\\[\\w+\\]";
    public static final String BASE_REGEX = "\\d+\\[\\w*\\]";
    public static final String CHECK_BRACKET = ".*\\[.*";

    String inboundString;
    Validator validator;
    public UnboxString(String inboundString) {
        validator = new Validator(inboundString);
        this.inboundString = inboundString;
    }



    public String unpackString() throws MyValidationException {

        validator.fullValidation();

        Pattern pattern = Pattern.compile(BASE_REGEX);
        while (inboundString.matches(CHECK_BRACKET)) {
            Matcher matcher = pattern.matcher(inboundString);
            matcher.find();
            String resultString = multipleString(matcher.group());
            inboundString = matcher.replaceFirst(resultString);
        }
        return inboundString;
    }

    // multiplying of substring, for example: 3[xy] = xyxyxy
    public String multipleString(String inbound) {
        StringBuilder string = new StringBuilder();
        int ratio = Integer.parseInt(inbound.replaceAll(REGEX_FOR_MULTIPLE, ""));
        String target = inbound.substring(inbound.indexOf('[') + 1, inbound.indexOf(']'));

        for (int i = 0; i < ratio; i++) {
            string.append(target);
        }
        String result = String.valueOf(string);
        return result;
    }

}
