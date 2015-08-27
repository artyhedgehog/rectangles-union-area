package ru.e_legion.rectanglesunionarea.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class FileSystemHelper implements IOHelper {
    private final String inputFileName;
    private final String outputFileName;


    public FileSystemHelper(final String inputFileName,
                            final String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public Reader getSourceReader() throws IOHelperException {
        final Reader reader;
        try {
            reader = new FileReader(inputFileName);
        } catch (FileNotFoundException e) {
            final String message;
            message = String.format("Unabled to create reader for file %s.",
                                    inputFileName);
            throw new IOHelperException(message, e);
        }
        return reader;
    }

    public void writeResult(String result) {
        System.out.println(result);
    }
}
