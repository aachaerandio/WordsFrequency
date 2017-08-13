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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordItem wordItem = (WordItem) o;

        if (word != null ? !word.equals(wordItem.word) : wordItem.word != null) return false;
        return frequency != null ? frequency.equals(wordItem.frequency) : wordItem.frequency == null;

    }
}
