package com.aachaerandio.wordsfrequency.presenter;

import com.aachaerandio.wordsfrequency.FileReader;
import com.aachaerandio.wordsfrequency.model.WordItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePresenter {

    public List<WordItem> loadData(FileReader fileReader) {
        List<WordItem> wordList = new ArrayList<>();
        if(fileReader != null) {
            HashMap<String, Integer> map = loadMap(fileReader);

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                wordList.add(new WordItem(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }

        return wordList;
    }

    private HashMap<String, Integer> loadMap(FileReader fileReader){
        String line;
        HashMap<String, Integer> map = new HashMap<>();
        do {
            line = fileReader.readLine();
            if (line != null) {
                String[] words = extractWords(line);
                addWordsToMap(words, map);
            }
        } while (line != null);

        return map;
    }

    private void addWordsToMap(String[] words, HashMap<String, Integer> map) {
        for (String word : words) {
            String loWord = word.toLowerCase();
            Integer frequency;
            if ((frequency = map.get(loWord)) == null) {
                frequency = 0;
            }
           map.put(loWord, ++frequency);
        }
    }

    /**
     * Splits the line into words, removing the non word characters first.
     * @param line
     * @return Array of words.
     */
    private String[] extractWords(String line){
        String regex = "([^a-zA-Z']+)'*\\1*";
        return line.replaceAll(regex, " ").trim().split("\\s+");
    }

}
