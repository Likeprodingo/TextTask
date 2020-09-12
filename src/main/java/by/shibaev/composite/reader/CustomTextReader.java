package by.shibaev.composite.reader;

import by.shibaev.composite.exception.CustomException;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomTextReader {
    private static CustomTextReader instance;

    private CustomTextReader(){}

    public static CustomTextReader getInstance(){
        if(instance == null){
            instance = new CustomTextReader();
        }
        return instance;
    }

    public String readFile(String fileName) throws CustomException {
        String text = "";
        Path path = Paths.get(fileName);

        if (Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path)) {
            try (Stream<String> dataStream = Files.lines(path)) {
                text = dataStream.collect(Collectors.joining());
            } catch (IOException | UncheckedIOException e) {
                throw new CustomException("read error.", e);
            }
        }
        return text;
    }
}
