/**
 * Contains shared behavior and state information for all Products.
 */

package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

public abstract class AbstractProduct {

  protected String manufacturer;
  protected String productName;
  protected Double price;
  protected Integer minimumAge;

  private static final Integer DEFAULT_AGE = 0;

  /**
   * Updates fields to reflect the creation of a new object with a minimum age.
   * @param manufacturer the manufacturer's name
   * @param productName the products name
   * @param price the price
   * @param minimumAge the minimum age
   */
  public AbstractProduct(String manufacturer, String productName, Double price,
      Integer minimumAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = minimumAge;
  }

  /**
   * Updates fields to reflect the creation of a new object.
   * @param manufacturer the manufacturer's name
   * @param productName the products name
   * @param price the price
   */
  public AbstractProduct(String manufacturer, String productName, Double price) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = DEFAULT_AGE;
  }

  /**
   * Returns the name of the manufacturer.
   * @return the manufacturer's name
   */
  public String getManufacturer() {
    return this.manufacturer;
  }

  /**
   * Returns the name of the product.
   * @return the products's name
   */
  public String getProductName() {
    return this.productName;
  }

  /**
   * Returns the price in dollars.
   * @return the price
   */
  public Double getPrice() {
    return this.price;
  }

  /**
   * Returns the minimumAge.
   * @return the minimum age
   */
  public Integer getMinimumAge() {
    return this.minimumAge;
  }

  /**
   * Returns true if two objects are of the same type.
   * @param other the other product to compare
   * @return true is objects are of the same type
   */
  public boolean isSameType(AbstractProduct other) {
    return this.getClass().equals(other.getClass());
  }

  /**
   * Adds this in given quantity to inventory.
   * @param quantity - number to add
   * @param inventory - inventory to add to
   */
  public abstract  void addToInventory(Integer quantity, Inventory inventory);

  /**
   * Removes this from Inventory.
   * @param quantity number to remove
   * @param inventory inventory to remove from
   */
  public abstract void removeFromInventory(Integer quantity, Inventory inventory);

  /**
   * Gets a substitute for self from inventory.
   * @param inventory the inventory to search
   * @return the replacement produce
   * @throws SubstitutionNotFoundException If no subsutition is found
   */
  public abstract AbstractProduct getSubstituteFromInventory(Inventory inventory)
      throws SubstitutionNotFoundException;

  /**
   * Checks inventory for stock of this.
   * @param quantity number to search for
   * @param inventory inventory to search
   * @return true if this is in stock in inventory
   */
  public abstract boolean checkStockFromInventory(Integer quantity, Inventory inventory);

  /**
   * returns true if other equals this.
   * @param other the other object to compare
   * @return whether other equals this
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    AbstractProduct that = (AbstractProduct) other;
    return manufacturer.equals(that.manufacturer)
        && productName.equals(that.productName)
        && price.equals(that.price)
        && minimumAge.equals(that.minimumAge);
  }
  /**
   * Returns a numeric representation of the object.
   * @return numeric representation of object
   */
  @Override
  public int hashCode() {
    return Objects.hash(manufacturer, productName, price, minimumAge);
  }
}
