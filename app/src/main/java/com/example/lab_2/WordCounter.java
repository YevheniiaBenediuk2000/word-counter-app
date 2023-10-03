package com.example.lab_2;

public class WordCounter {
    public static int getWordsCount(String phrase){
        String[] words = phrase.split("\\s"); // Split by spaces
        return words.length;
    }
    public static int getCharsCount(String phrase){
        return phrase.length();
    }
}
