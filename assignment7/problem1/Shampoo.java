package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Represents a shampoo item available for purchase in the store.
 */

public class Shampoo extends AbstractHouseholdProduct {

  /**
   * Creates a Shampoo object.
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param numUnits the number of units in a package
   */
  public Shampoo(String manufacturer, String productName, Double price,
      Integer numUnits) {
    super(manufacturer, productName, price, numUnits);
  }
}
