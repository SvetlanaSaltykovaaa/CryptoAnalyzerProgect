package javarush.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class Decoder {

    public Decoder() {
    }

    Encoder encoder = new Encoder();

    public String decodeText(String text, int key) {
        return  encoder.encodeText(text,- key);
    }

    public Path getNewFileNameForDecoded(Path path) {
        String str = path.toString();
        int dotIndex = str.lastIndexOf(".");
        str = str.substring(0, dotIndex) + "_decoded" + str.substring(dotIndex);
        path = Path.of(str);

        return path;
    }

    public void writeToFile(Path filePath,String decodedText){
        try {
            Files.writeString(getNewFileNameForDecoded(filePath), decodedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
