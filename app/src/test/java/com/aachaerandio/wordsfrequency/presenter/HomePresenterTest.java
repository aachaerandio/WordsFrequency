package com.aachaerandio.wordsfrequency.presenter;

import com.aachaerandio.wordsfrequency.FileReader;
import com.aachaerandio.wordsfrequency.model.WordItem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomePresenterTest {
    @Mock
    private FileReader fileReader;
    HomePresenter homePresenter;

    @Before
    public void setUp() throws Exception {
        homePresenter = new HomePresenter();
    }

    @Test
    public void should_load_data_successfully() throws Exception {
        when(fileReader.readLine())
                .thenReturn("hello hello world")
                .thenReturn("HELLO! world")
                .thenReturn(null);
        List<WordItem> wordItems = homePresenter.loadData(fileReader);
        Assert.assertTrue(wordItems.contains(new WordItem("hello","3")));
        Assert.assertTrue(wordItems.contains(new WordItem("world","2")));
    }

    @Test
    public void should_return_empty_when_file_does_not_exist() throws Exception {
        List<WordItem> wordItems = homePresenter.loadData(null);
        Assert.assertNotNull(wordItems);
        Assert.assertEquals(0, wordItems.size());
    }

    @Test
    public void should_return_empty_when_file_is_empty() throws Exception {
        when(fileReader.readLine()).thenReturn(null);
        List<WordItem> wordItems = homePresenter.loadData(fileReader);
        Assert.assertNotNull(wordItems);
        Assert.assertEquals(0, wordItems.size());
    }
}