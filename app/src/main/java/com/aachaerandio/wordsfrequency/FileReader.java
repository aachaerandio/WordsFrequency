package com.aachaerandio.wordsfrequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileReader {

    private BufferedReader bufferedReader;

    public static FileReader create(String fileName){
        InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(fileName);
        if(inputStream != null) {
            try {
                return new FileReader(inputStream);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    private FileReader(InputStream inputStream) throws UnsupportedEncodingException {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    }

    public String readLine() {
        String line;
        try {
            do {
                line = bufferedReader.readLine();
            } while(line != null && !validateLine(line));

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return line;
    }

    private boolean validateLine(String line) {
        return !line.replaceAll("\\W", " ").trim().equals("");
    }

    public void close(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
