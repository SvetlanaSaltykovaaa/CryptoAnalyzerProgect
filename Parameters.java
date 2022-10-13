package javarush.project;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class Parameters {

    public static String validateOperation(String operation) {

        String[] operations = {"encode", "decode"};
        for (String action : operations) {
            if (action.equalsIgnoreCase(operation)) {
                return action;
            }
        }
        throw new RuntimeException("No valid operation!");
    }

    public static Path validatePath(String filePath) {

        Path path = Path.of(filePath);
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            throw new RuntimeException("No file founded!");
        }
        if (!path.endsWith(".txt")) {
            throw new RuntimeException("Unacceptable file format!");
        }
        return path;
    }

    public static int validateKey(String stringKey) {
        int key = Integer.parseInt(stringKey);
        if (key == 0) {
            throw new RuntimeException("Key value should be negative or positive!");
        }
        return key;
    }

    public  void validateArgsLength(String[] args){
        if (args.length >3 ){
            throw  new IllegalArgumentException("Args length should be 3. You input " + args.length);

        }
    }
}

