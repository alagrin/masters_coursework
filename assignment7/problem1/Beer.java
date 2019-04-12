package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Represents beer for sale with a minimum purchase age of 21.
 */

public class Beer extends AbstractGroceryProduct {

  private static final Integer DRINKING_AGE = 21;

  /**
   * Creates a new beer object with a minimum purchase age of 21.
   * @param manufacturer the company that produced the item
   * @param productName the name of the product
   * @param price price
   * @param weightInOunces weight of the product
   */
  public Beer(String manufacturer, String productName, Double price,Double weightInOunces) {
    super(manufacturer, productName, price, DRINKING_AGE, weightInOunces);
  }

}
