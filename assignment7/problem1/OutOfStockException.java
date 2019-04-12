package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Exception indicating there are fewer items in stock than requested.
 */


public class OutOfStockException extends RuntimeException {

  /**
   * Creates  new OutOfStockException.
   * @param message the message to include
   */
  public OutOfStockException(String message) {
    super(message);
  }
}
