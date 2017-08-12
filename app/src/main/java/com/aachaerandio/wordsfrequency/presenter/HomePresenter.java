package com.aachaerandio.wordsfrequency.presenter;

import com.aachaerandio.wordsfrequency.model.WordItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePresenter {

    public List<WordItem> loadData() {
        List<WordItem> dataList = new ArrayList<>();
        WordItem item1 = new WordItem("hello", "430543298");
        WordItem item2 = new WordItem("bye", "11");
        dataList.add(item1);
        dataList.add(item2);

        return dataList;
    }

    public HashMap<String, Integer> loadHashMap(){
        return null;
    }

    public void extractWords(String line){

    }

}
