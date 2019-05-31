/**
 * Represents salmon available for purchase.
 */

package edu.neu.ccs.cs5004.assignment7.problem1;

public class Salmon extends AbstractGroceryProduct {

  /**
   * Created a new salmon object with no minimum purchase age.
   * @param manufacturer the company that produced the item
   * @param productName the name of the product
   * @param price price
   * @param weightInOunces weight of the product
   */
  public Salmon(String manufacturer, String productName, Double price,
      Double weightInOunces) {
    super(manufacturer, productName, price, weightInOunces);
  }




}
