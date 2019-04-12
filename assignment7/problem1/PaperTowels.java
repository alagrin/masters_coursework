/**
 * Represents paper towels available for purchase in the store.
 */

package edu.neu.ccs.cs5004.assignment7.problem1;

public class PaperTowels extends AbstractHouseholdProduct {

  /**
   * Creates a new PaperTowel object.
   * @param manufacturer the name of the manufacturer
   * @param productName the product name
   * @param price the price
   * @param numUnits the number of units
   */
  public PaperTowels(String manufacturer, String productName, Double price,
      Integer numUnits) {
    super(manufacturer, productName, price, numUnits);
  }
}
