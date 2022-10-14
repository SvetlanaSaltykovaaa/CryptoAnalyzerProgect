package javarush.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
            char charElement = builder.charAt(i);

            boolean isSmallEnglishCharacter = charElement >= 'a' && charElement <= 'z';
            boolean isBigEnglishCharacter = charElement >= 'A' && charElement <= 'Z';
            boolean isSmallCyrillicCharacter = charElement >= 'а' && charElement <= 'я';
            boolean isBigCyrillicCharacter = charElement >= 'А' && charElement <= 'Я';


            if (isSmallEnglishCharacter) {
                int indexOfAlphabet = dic.ENGLISH_ALPHABET.indexOf(charElement);
               Collections.rotate(dic.ENGLISH_ALPHABET,key);
                builder.setCharAt(i, dic.ENGLISH_ALPHABET.get(indexOfAlphabet));
            } else if (isBigEnglishCharacter) {
                int indexOfUpperAlphabet = dic.ENGLISH_ALPHABETUPPERCASE.indexOf(charElement);
                Collections.rotate(dic.ENGLISH_ALPHABETUPPERCASE,key);
                builder.setCharAt(i, dic.ENGLISH_ALPHABETUPPERCASE.get(indexOfUpperAlphabet));
            } else if (isSmallCyrillicCharacter) {
                int indexOfAlphabet = dic.CYRILLIC_ALPHABET.indexOf(charElement);
               Collections.rotate(dic.ENGLISH_ALPHABET,key);
                builder.setCharAt(i, dic.CYRILLIC_ALPHABET.get(indexOfAlphabet));
            } else if (isBigCyrillicCharacter) {
                int indexOfAlphabet = dic.CYRILLIC_ALHABETUPPERCASE.indexOf(charElement);
              Collections.rotate(dic.CYRILLIC_ALHABETUPPERCASE,key);
                builder.setCharAt(i, dic.CYRILLIC_ALHABETUPPERCASE.get(indexOfAlphabet));
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

    public void writeToFile(Path filePath,String decodedText){
        try {
            Files.writeString(getNewFileNameForEncoded(filePath), decodedText, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



