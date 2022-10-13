package javarush.project;

import java.nio.file.Path;
import java.util.Collections;

public class Decoder {

    public Decoder() {
    }

    Encoder encoder = new Encoder();

    public String decodeText(String text, int key) {
        key = -key;
        return  encoder.encodeText(text,key);
    }

    public Path getNewFileNameForDecoded(Path path) {
        String str = path.toString();
        int dotIndex = str.lastIndexOf(".");
        str = str.substring(0, dotIndex) + "_decoded" + str.substring(dotIndex);
        path = Path.of(str);

        return path;
    }
}
