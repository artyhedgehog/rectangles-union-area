package ru.e_legion.rectanglesunionarea.models;

/**
 * Abstraction for rectangles union factory.
 */
public interface RectanglesUnionFactory {
    /**
     * Create rectangles union by implementation-specific data source.
     * @return A resulting union.
     * @throws WrongInputException If set up source has some wrong data.
     */
    RectanglesUnion create() throws WrongInputException;
}
