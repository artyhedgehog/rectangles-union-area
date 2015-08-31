package ru.e_legion.rectanglesunionarea.models;

public class WrongInputException extends Exception {
    public static final String
            MESSAGE_FORMAT = "Wrong input format in line %d, token %d: %s.";
    protected int line;
    protected int tokenNumber;


    public WrongInputException(int line, int tokenNumber, String reason) {
        super(getMessage(line, tokenNumber, reason));
        this.line = line;
        this.tokenNumber = tokenNumber;
    }

    public WrongInputException(int line, int tokenNumber, String reason,
                               Throwable cause) {
        super(getMessage(line, tokenNumber, reason), cause);
        this.line = line;
        this.tokenNumber = tokenNumber;
    }


    public int getLine() {
        return line;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }


    private static String getMessage(int line, int tokenNumber, String reason) {
        return String.format(MESSAGE_FORMAT, line, tokenNumber, reason);
    }
}
