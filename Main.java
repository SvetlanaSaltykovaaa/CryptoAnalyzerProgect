package javarush.project;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

    private  static final  String ENCODE = "encode";
    private static final String DECODE = "decode";


     public static void main(String[] args) throws IOException {
        String operation = Parameters.validateOperation(args[0]);
        Path filePath = Parameters.validatePath(args[1]);
        int key = Parameters.validateKey(args[2]);

        String inputText = Files.readString(filePath);

        switch (operation) {
            case ENCODE -> {
                Encoder encoder = new Encoder();
                String encodedText = encoder.encodeText(inputText, key);
                Files.writeString(encoder.getNewFileNameForEncoded(filePath), encodedText, StandardOpenOption.CREATE);
            }
            case DECODE -> {
                Decoder decoder = new Decoder();
                String decodedText = decoder.decodeText(inputText, key);
                Files.writeString(decoder.getNewFileNameForDecoded(filePath), decodedText, StandardOpenOption.CREATE);
            }
            default -> {
                System.out.println("Unknown operation");
            }
        }

    }
}



