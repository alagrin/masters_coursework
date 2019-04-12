package edu.neu.ccs.cs5004.problem1;

/**
 * Thrown when year is incorrect value.
 */
public class InvalidYearException extends RuntimeException {

  InvalidYearException(String exc) {
    System.out.println(exc);
  }
}
