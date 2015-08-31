package ru.e_legion.rectanglesunionarea.io;

import java.io.Reader;

/**
 * Main abstraction of the package. Used to provide with input data reader and
 * write result of calculation.
 */
public interface IOHelper {
    /**
     * Provides with an appropriate input data reader.
     * @return Reader to use for creation of models.
     * @throws IOHelperException on failed creating a reader.
     */
    Reader getSourceReader() throws IOHelperException;

    /**
     * Write calculation result to appropriate output.
     * @param result Readable calculation result representation.
     * @throws IOHelperException on failed writing result to destination.
     */
    void writeResult(String result) throws IOHelperException;
}
