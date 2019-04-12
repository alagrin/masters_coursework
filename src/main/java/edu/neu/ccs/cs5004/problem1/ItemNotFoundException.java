package edu.neu.ccs.cs5004.problem1;

/**
 * Thrown when item not found in library.
 */
public class ItemNotFoundException extends RuntimeException {

  ItemNotFoundException(String exc) {
    System.out.println(exc);
  }
}
