package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public static void beautify(String text, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(text);
        System.out.println("After beautify: " + result);

    }
}
