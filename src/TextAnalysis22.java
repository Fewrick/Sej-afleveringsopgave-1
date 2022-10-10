import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class TextAnalysis22 {
    private ArrayList<String> words;

    private ArrayList<String> split(File file, int maxNoOfWords) throws IOException {
        ArrayList<String> words = new ArrayList<String>();

        String text = Files.readString(file.toPath());

        char[] arr = text.toCharArray();

        String word = "";

        // Den læser filer et tegn af gangen, og hvis tegnet er et bogstav tilføjes den
        // til det nuværende ord. Hvis ikke, tilføjes ordet til listen af ord. Det giver
        // end array af ord, hvor der ikke bliver gemt tegnsætning. Kun ordene.

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

            // Hvis der er for mange ord i teksten, skal den stoppe med at læse videre.
            // Man kan stadig kalde metoderne på instancen men den vil bare ikke
            // nødvendigvis give det svar man ønsker.

            // Siden vi bruger en arrayList i stedet for en array[maxNoOfWords] er dette
            // teknisk set overflødigt.

            if (words.size() > maxNoOfWords) {
                break;
            }
        }
        if (word != "" && words.size() < maxNoOfWords) {
            words.add(word);
        }

        return words;
    }

    // Det er MEGET med vilje at constructoren kaster en IOException, da det er god
    // praxis at håndterer fejlen, der hvor der en en metode der bliver kaldt med
    // dårlige argumenter. Da det ikke er mig som bestemmer hvad argumetnerne til
    // sourceFileName er, skal det heller ikke være mig som håndterer fejlen.

    public TextAnalysis22(String sourceFileName, int maxNoOfWords) throws IOException {
        File file = new File(sourceFileName);
        words = split(file, maxNoOfWords);
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

        // Bemærk at det er længden af arrayen minus 1. For man kan ikke finde ordet
        // efter det sidste ord. Man kan i teorien bruge modulus så det sidste ord ser
        // det første som det næste, men det er ikke en del af opgaven.

        for (int i = 0; i < words.size() - 1; i++) {
            if (words.get(i).toLowerCase().equals(word1.toLowerCase())
                    && words.get(i + 1).toLowerCase().equals(word2.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}