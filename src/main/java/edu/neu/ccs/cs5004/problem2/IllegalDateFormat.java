package edu.neu.ccs.cs5004.problem2;

/**
 * Indicates a date string in incorrectly formatted.
 */
public class IllegalDateFormat extends Exception {

  /**
   * Constructs a new exception with the specified detail message.
   *
   * @param message the detail message.
   */
  public IllegalDateFormat(String message) {
    super(message);
  }
}
