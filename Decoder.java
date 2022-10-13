package javarush.project;

import java.nio.file.Path;
import java.util.Collections;

public class Decoder {

    public Decoder() {
    }

    Dictionary dic = new Dictionary();
    Encoder encoder = new Encoder();

    public String decodeText(String text, int key) {
        key = -key;
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

    public Path getNewFileNameForDecoded(Path path) {
        String str = path.toString();
        int dotIndex = str.lastIndexOf(".");
        str = str.substring(0, dotIndex) + "_decoded" + str.substring(dotIndex);
        path = Path.of(str);

        return path;
    }
}
