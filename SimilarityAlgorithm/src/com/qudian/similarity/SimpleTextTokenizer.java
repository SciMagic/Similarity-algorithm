package com.qudian.similarity;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * SimpleTextTokenizer
 */
public class SimpleTextTokenizer {

    private final List<String> filterWords;

    public SimpleTextTokenizer() {

        filterWords = new ArrayList<String>();

        String pathname = "/resources/onomatopoeia.txt";

        try {
            InputStream is = this.getClass().getResourceAsStream(pathname);

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            // 网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                line = line.toLowerCase();
                filterWords.add(line);
            }

            br.close();

        } catch (Exception e) {

        } finally {

        }

    }

    public SimpleTextTokenizer(File filterFile) {

        filterWords = new ArrayList<String>();

        String pathname = "/resources/onomatopoeia.txt";

        try {

            BufferedReader br;

            if (!filterFile.exists()) {
                InputStream is = this.getClass().getResourceAsStream(pathname);
                br = new BufferedReader(new InputStreamReader(is));

            } else {
                FileReader reader = new FileReader(filterFile);
                br = new BufferedReader(reader);
            }

            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                filterWords.add(line);
            }
            br.close();

        } catch (Exception e) {

        } finally {

        }

    }

    public List<String> expand(String text) {

        text = text.toLowerCase();

        for (String word : filterWords) {

            text = text.replace(word, "");

        }

        text = text.replace('’', '\'');
        text = text.replace('‘', ' ');
        text = text.replace("'", "");
        text = text.replace('”', ' ');
        text = text.replace('“', ' ');
        text = text.replace('"', ' ');
        text = text.replace('»', ' ');
        text = text.replace('«', ' ');
        text = text.replace('–', '-');
        text = text.replace('—', ' ');
        text = text.replace('…', ' ');

        text = text.replace(" - ", " ");
        text = text.replaceAll("[/_*%]", " ");
        // text = text.toLowerCase();

        String[] tokens = text.split("[.,?:!;()]");

        List<String> splitString = Arrays.asList(tokens);
        List<String> wordList = sentenceToWords(splitString);

        return wordList;
    }

    public TreeSet<String> expandSentence(List<String> words1, List<String> words2) {

        TreeSet<String> tSet = new TreeSet<String>();

        for (String word : words1) {

            tSet.add(word);

        }

        for (String word : words2) {

            tSet.add(word);

        }

        return tSet;
    }

    protected List<String> sentenceToWords(List<String> sentenceTranscript) {
        ArrayList<String> transcript = new ArrayList<String>();
        for (String sentence : sentenceTranscript) {
            String[] words = sentence.split("\\s+");
            for (String word : words) {
                if (word.length() > 0)
                    transcript.add(word);
            }
        }
        return transcript;
    }

}