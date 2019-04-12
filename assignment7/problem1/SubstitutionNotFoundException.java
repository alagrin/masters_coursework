package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Indicates no suitable substitution was found.
 */

public class SubstitutionNotFoundException extends RuntimeException {

  /**
   * Constructs a new exception with the specified detail message.    *
   * @param message the detail message.
   */
  public SubstitutionNotFoundException(String message) {
    super(message);
  }
}
