
package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Cheese that is available for purchase in the store.
 */

public class Cheese extends AbstractGroceryProduct{

  /**
   * Creates a new cheese object with no minimum purchase age.
   * @param manufacturer the company that produced the item
   * @param productName the name of the product
   * @param price price
   * @param weightInOunces weight of the product
   */
  public Cheese(String manufacturer, String productName, Double price,
      Double weightInOunces) {
    super(manufacturer, productName, price, weightInOunces);
  }
}
