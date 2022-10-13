package javarush.project;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Encoder {

    public Encoder() {
    }

    Dictionary dic = new Dictionary();

    public String encodeText(String text, int key) {
        StringBuilder builder = new StringBuilder(text);

        for (int i = 0; i < builder.length(); i++) {
            char element = builder.charAt(i);
            if (element >= 'a' && element <= 'z') {
                int indexOfAlphabet = dic.ALPHABET.indexOf(element);
                Collections.rotate(dic.ALPHABET,key);
                builder.setCharAt(i, dic.ALPHABET.get(indexOfAlphabet));

            } else if (element >= 'A' && element <= 'Z') {
                int indexOfUpperAlphabet = dic.ALPHABETUPPERCASE.indexOf(element);
                Collections.rotate(dic.ALPHABETUPPERCASE,key);
                builder.setCharAt(i, dic.ALPHABETUPPERCASE.get(indexOfUpperAlphabet));
            }
        }
        return builder.toString();
    }

    public Path getNewFileNameForEncoded(Path path) {
        String str = path.toString();
        int dotIndex = str.lastIndexOf(".");
        str = str.substring(0, dotIndex) + "_encoded" + str.substring(dotIndex);
        path = Path.of(str);

        return path;

    }
}



