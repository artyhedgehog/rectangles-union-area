package ru.e_legion.rectanglesunionarea;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;

public class CSVReaderRectanglesUnionFactory {
    private CSVReader reader;

    public CSVReaderRectanglesUnionFactory(Reader reader) {
        this.reader = new CSVReader(reader, ' ');
    }
    
    public RectanglesUnion create() {
        String[] line;
        RectanglesUnion union = new RectanglesUnion();
        try {
            while (null != (line = reader.readNext())) {
                union.add(new Rectangle(Integer.parseInt(line[0]),
                                        Integer.parseInt(line[1]),
                                        Integer.parseInt(line[2]),
                                        Integer.parseInt(line[3])));
            }
            return union;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
