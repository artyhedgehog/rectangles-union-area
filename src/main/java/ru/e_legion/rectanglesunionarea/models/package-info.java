/**
 * Package for domain logic.
 * Consists mostly of {@link ru.e_legion.rectanglesunionarea.models.Rectangle}
 * as main atomic model and
 * {@link ru.e_legion.rectanglesunionarea.models.RectanglesUnion} for result
 * union computations.
 * Also includes interface if
 * {@link ru.e_legion.rectanglesunionarea.models.RectanglesUnionFactory} as
 * abstraction for means of creating models based on input data provided and
 * {@link ru.e_legion.rectanglesunionarea.models.CSVReaderRectanglesUnionFactory},
 * which is an implementation based on CSVReader library configured to read
 * files with four integer coordinates per line with spaces as separation.
 */
package ru.e_legion.rectanglesunionarea.models;