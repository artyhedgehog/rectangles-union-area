package ru.e_legion.rectanglesunionarea;

import java.io.Reader;

import ru.e_legion.rectanglesunionarea.io.FileSystemHelper;
import ru.e_legion.rectanglesunionarea.io.IOHelperException;
import ru.e_legion.rectanglesunionarea.io.IOHelper;
import ru.e_legion.rectanglesunionarea.models.CSVReaderRectanglesUnionFactory;
import ru.e_legion.rectanglesunionarea.models.RectanglesUnion;
import ru.e_legion.rectanglesunionarea.models.RectanglesUnionFactory;
import ru.e_legion.rectanglesunionarea.models.WrongInputException;

/**
 * Main static class from which the application execution should start.
 */
public class Main {

    public static final String
            FORMAT_ERROR_ARGS_COUNT = "Expected 2 arguments, %d given.";

    /**
     * Read coordinates of rectangles from first specified file and write their
     * union area into the second specified file.
     *
     * @param args expects two arguments: a name of file with lines each
     *             representing a rectangle coordinates (x1, y1, x2, y2)
     *             separated with spaces and a name of file to write result to
     * @throws IOHelperException
     * @throws WrongInputException
     */
    public static void main(final String[] args)
            throws IOHelperException, WrongInputException {
        final IOHelper ioHelper;
        final Reader reader;
        final RectanglesUnionFactory factory;
        final RectanglesUnion union;

        if (args.length != 2) {
            final String message;
            message = String.format(FORMAT_ERROR_ARGS_COUNT, args.length);
            throw new IllegalArgumentException(message);
        }

        ioHelper = new FileSystemHelper(args[0], args[1]);
        reader = ioHelper.getSourceReader();
        factory = new CSVReaderRectanglesUnionFactory(reader);
        union = factory.create();
        ioHelper.writeResult(Integer.toString(union.area()));
    }
}
