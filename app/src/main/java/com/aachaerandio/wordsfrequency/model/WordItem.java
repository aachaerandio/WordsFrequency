package com.aachaerandio.wordsfrequency.model;

public class WordItem {

    private String word;
    private String frequency;

    public WordItem(String word, String frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public String getFrequency() {
        return frequency;
    }
}
