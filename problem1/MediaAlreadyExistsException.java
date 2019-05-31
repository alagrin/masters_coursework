package edu.neu.ccs.cs5004.problem1;

/**
 * Thrown when media already is in the library.
 */
public class MediaAlreadyExistsException extends RuntimeException {

  public MediaAlreadyExistsException(String exc) {
    System.out.println(exc);
  }
}
