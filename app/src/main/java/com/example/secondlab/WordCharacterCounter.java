package com.example.secondlab;

public class WordCharacterCounter {

    public static int getCount(String inputText, String selectedOption) {
        if (selectedOption.equals("Words")) {
            return countWords(inputText);
        } else if (selectedOption.equals("Characters")) {
            return countCharacters(inputText);
        }
        return 0;
    }
    private static int countWords(String inputText) {
        String[] words = inputText.trim().split("[\\s,\\.]+");
        return words.length;
    }
    private static int countCharacters(String inputText) {
        return inputText.length();
    }
}
