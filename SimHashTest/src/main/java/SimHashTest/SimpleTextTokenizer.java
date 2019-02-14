package SimHashTest;

import java.util.List;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * SimpleTextTokenizer
 */
public class SimpleTextTokenizer {

    public List<String> expand(String text) {

        text = text.replace('’', '\'');
        text = text.replace('‘', ' ');
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
        text = text.toLowerCase();

        String[] tokens = text.split("[.,?:!;()]");

        List<String> splitString = Arrays.asList(tokens);
        List<String> wordList = sentenceToWords(splitString);

        return wordList;
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
