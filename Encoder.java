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
                int indexOfAlphabet = dic.ENGLISH_ALPHABET.indexOf(element);
                Collections.rotate(dic.ENGLISH_ALPHABET, key);
                builder.setCharAt(i, dic.ENGLISH_ALPHABET.get(indexOfAlphabet));

            } else if (element >= 'A' && element <= 'Z') {
                int indexOfUpperAlphabet = dic.ENGLISH_ALPHABETUPPERCASE.indexOf(element);
                Collections.rotate(dic.ENGLISH_ALPHABETUPPERCASE, key);
                builder.setCharAt(i, dic.ENGLISH_ALPHABETUPPERCASE.get(indexOfUpperAlphabet));
            } else if (element >= 'а' && element <= 'я') {
                int indexOfAlphabet = dic.CIRILIC_ALPHABET.indexOf(element);
                Collections.rotate(dic.CIRILIC_ALPHABET, key);
                builder.setCharAt(i, dic.CIRILIC_ALPHABET.get(indexOfAlphabet));
            } else if (element >= 'А' && element <= 'Я') {
                int indexOfAlphabet = dic.CIRILIC_ALHABETUPPERCASE.indexOf(element);
                Collections.rotate(dic.CIRILIC_ALHABETUPPERCASE, key);
                builder.setCharAt(i, dic.CIRILIC_ALHABETUPPERCASE.get(indexOfAlphabet));
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



