package com.kodilla.stream.beautifier;

import java.util.Locale;

public class TextBeatyfier {
    public static String abcAdd(String text) {
        String result = "ABC " + text + " CBA";
        return result;
    }

    public static String capitalLetters(String text) {
        String result = text.toUpperCase();
        return result;
    }

    public static String smallLetters(String text) {
        String result = text.toLowerCase();
        return result;
    }

    public static String addStar(String text) {
        String result = "* " + text + " *";
        return result;
    }
}
