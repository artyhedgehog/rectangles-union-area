package ru.e_legion.rectanglesunionarea;

import java.io.Reader;

import ru.e_legion.rectanglesunionarea.io.FileSystemHelper;
import ru.e_legion.rectanglesunionarea.io.IOHelperException;
import ru.e_legion.rectanglesunionarea.io.IOHelper;
import ru.e_legion.rectanglesunionarea.models.CSVReaderRectanglesUnionFactory;
import ru.e_legion.rectanglesunionarea.models.RectanglesUnion;
import ru.e_legion.rectanglesunionarea.models.RectanglesUnionFactory;
import ru.e_legion.rectanglesunionarea.models.WrongInputException;

public class Main {

    public static final String
            FORMAT_ERROR_ARGS_COUNT = "Expected 2 arguments, %d given.";

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
