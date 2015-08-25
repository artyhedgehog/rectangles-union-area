package ru.e_legion.rectanglesunionarea;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        FileReader reader;
        CSVReaderRectanglesUnionFactory factory;
        RectanglesUnion union;

        try {
            reader = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        factory = new CSVReaderRectanglesUnionFactory(reader);
        union = factory.create();
        System.out.println(union.area());
    }
}
