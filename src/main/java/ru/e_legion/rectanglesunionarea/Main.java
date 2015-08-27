package ru.e_legion.rectanglesunionarea;

import java.io.Reader;

import ru.e_legion.rectanglesunionarea.io.FileSystemHelper;
import ru.e_legion.rectanglesunionarea.io.IOHelperException;
import ru.e_legion.rectanglesunionarea.io.IOHelper;
import ru.e_legion.rectanglesunionarea.models.CSVReaderRectanglesUnionFactory;
import ru.e_legion.rectanglesunionarea.models.RectanglesUnion;
import ru.e_legion.rectanglesunionarea.models.RectanglesUnionFactory;

public class Main {
    public static void main(final String[] args) throws IOHelperException {
        final IOHelper ioHelper;
        final Reader reader;
        final RectanglesUnionFactory factory;
        final RectanglesUnion union;

        ioHelper = new FileSystemHelper(args[0], args[1]);
        reader = ioHelper.getSourceReader();
        factory = new CSVReaderRectanglesUnionFactory(reader);
        union = factory.create();
        ioHelper.writeResult(Integer.toString(union.area()));
    }
}
