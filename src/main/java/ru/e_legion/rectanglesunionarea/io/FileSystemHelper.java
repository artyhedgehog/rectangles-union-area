package ru.e_legion.rectanglesunionarea.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Implementation to operate with files as data input and result output.
 */
public class FileSystemHelper implements IOHelper {
    private final String inputFileName;
    private final String outputFileName;

    /**
     * @param inputFileName Name of file with models creation data.
     * @param outputFileName Name of file to put result into.
     */
    public FileSystemHelper(final String inputFileName,
                            final String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    /**
     * Get a reader based on input file specified on object creation.
     * @return A file reader for specified file.
     * @throws IOHelperException on not found the file specified.
     */
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

    /**
     * Write result to an output file specified on object creation.
     * @param result Readable calculation result representation.
     * @throws IOHelperException on output failure.
     */
    public void writeResult(String result) throws IOHelperException {
        try (final Writer writer = new FileWriter(outputFileName)) {
            writer.write(result);
        } catch (IOException e) {
            final String message;
            message = String.format("Unabled to write result to a file %s.",
                                    outputFileName);
            throw new IOHelperException(message, e);
        }
    }
}
