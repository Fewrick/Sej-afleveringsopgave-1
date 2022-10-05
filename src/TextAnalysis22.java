import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class TextAnalysis22 {
    ArrayList<String> words;

    ArrayList<String> split(File file) {
        ArrayList<String> words = new ArrayList<String>();
        String text = "";
        try {
            text = Files.readString(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        char[] arr = text.toCharArray();

        String word = "";

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isLetter(c)) {
                word += c;
            } else {
                if (word != "") {
                    words.add(word);
                    word = "";
                }
            }
        }
        if (word != "") {
            words.add(word);
        }

        return words;
    }

    public TextAnalysis22(String sourceFileName, int maxNoOfWords) {
        File file = new File(sourceFileName);
        words = split(file);
    }

    public int wordCount() {
        return words.size();
    }

    public int frequency(String word) {
        int freq = 0;
        for (String str : words) {
            if (str.equals(word)) {
                freq += 1;
            }
        }

        return freq;
    }

    public boolean contains(String word1, String word2) {

        for (int i = 0; i < words.size() - 1; i++) {
            if (words.get(i).toLowerCase().equals(word1.toLowerCase())
                    && words.get(i + 1).toLowerCase().equals(word2.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}