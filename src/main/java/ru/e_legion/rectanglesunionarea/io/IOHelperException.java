package ru.e_legion.rectanglesunionarea.io;

public class IOHelperException extends Exception {
    public IOHelperException() {
    }

    public IOHelperException(String message) {
        super(message);
    }

    public IOHelperException(String message, Throwable cause) {
        super(message, cause);
    }

    public IOHelperException(Throwable cause) {
        super(cause);
    }

    public IOHelperException(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
