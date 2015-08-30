package ru.e_legion.rectanglesunionarea.io;

import java.io.Reader;

public interface IOHelper {
    Reader getSourceReader() throws IOHelperException;

    void writeResult(String result) throws IOHelperException;
}
