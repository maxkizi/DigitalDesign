package ru.maxkizi.javapractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnboxString {

    public static final String REGEX_FOR_MULTIPLE = "\\[\\w+\\]";
    public static final String BASE_REGEX = "\\d+\\[\\w*\\]";
    public static final String CHECK_BRACKET = ".*\\[.*";

    private Pattern pattern;

    public String unpackString(String inbound) {

        pattern = Pattern.compile(BASE_REGEX);

        while (inbound.matches(CHECK_BRACKET)) {
            Matcher matcher = pattern.matcher(inbound);
            matcher.find();
            String resultString = multipleString(matcher.group());
            inbound = matcher.replaceFirst(resultString);
        }
        return inbound;
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
