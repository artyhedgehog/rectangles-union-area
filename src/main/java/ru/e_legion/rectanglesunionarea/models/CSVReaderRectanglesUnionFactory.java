package ru.e_legion.rectanglesunionarea.models;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;

public class CSVReaderRectanglesUnionFactory implements RectanglesUnionFactory {
    public static final String
            ERROR_TOKENS_COUNT = "expected %d tokens in line";
    public static final String
            ERROR_NOT_NUMBER = "failed parsing a number from string '%s'";
    public static final String
            ERROR_OUT_OF_RANGE = "coordinate must be between -10000 and 10000";
    public static final String
            ERROR_LINES_COUNT = "lines count exceeded the limit";

    public static final int TOKENS_PER_LINE = 4;
    public static final int LINES_LIMIT = 100;
    public static final int MIN_COORDINATE = -10000;
    public static final int MAX_COORDINATE = 10000;

    private CSVReader reader;


    public CSVReaderRectanglesUnionFactory(Reader reader) {
        this.reader = new CSVReader(reader, ' ');
    }


    public RectanglesUnion create() throws WrongInputException {
        RectanglesUnion union;
        String[] lineTokens;
        int lineNumber;

        union = new RectanglesUnion();
        try {
            for (lineNumber = 1, lineTokens = reader.readNext();
                 null != lineTokens && lineNumber < LINES_LIMIT;
                 ++lineNumber, lineTokens = reader.readNext()) {
                if (lineTokens.length != TOKENS_PER_LINE) {
                    final String reason;
                    final int position;
                    reason = String.format(ERROR_TOKENS_COUNT, TOKENS_PER_LINE);
                    position = Math.min(lineTokens.length, TOKENS_PER_LINE);
                    throw new WrongInputException(lineNumber, position, reason);
                }

                final int x1, y1, x2, y2;
                x1 = validateAndGetCoordinate(lineTokens[0], lineNumber, 0);
                y1 = validateAndGetCoordinate(lineTokens[1], lineNumber, 1);
                x2 = validateAndGetCoordinate(lineTokens[2], lineNumber, 2);
                y2 = validateAndGetCoordinate(lineTokens[3], lineNumber, 3);
                union.add(new Rectangle(x1, y1, x2, y2));
            }
            if (lineNumber >= LINES_LIMIT) {
                throw new WrongInputException(lineNumber, 0, ERROR_LINES_COUNT);
            }
            return union;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private int validateAndGetCoordinate(final String token, final int line,
                                         final int tokenNumber)
            throws WrongInputException {
        final int coordinate;
        try {
            coordinate = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            final String reason = String.format(ERROR_NOT_NUMBER, token);
            throw new WrongInputException(line, tokenNumber, reason, e);
        }
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            throw new WrongInputException(line, tokenNumber, ERROR_OUT_OF_RANGE);
        }
        return coordinate;
    }
}
