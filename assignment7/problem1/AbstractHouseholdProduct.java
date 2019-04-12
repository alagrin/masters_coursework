
package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Contains all of the shared state information for house hold products.
 */

public abstract class AbstractHouseholdProduct extends AbstractProduct {

  protected Integer numUnits;

  /**
   * Allows for creation of household products with no minimum age.
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param numUnits the number of units in a package
   */
  public AbstractHouseholdProduct(String manufacturer, String productName, Double price,
      Integer numUnits) {
    super(manufacturer, productName, price);
    this.numUnits = numUnits;
  }

  /**
   * Allows for creation of household products with no minimum age.
   * @param manufacturer the manufacturer
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param numUnits the number of units in a package
   */
  public AbstractHouseholdProduct(String manufacturer, String productName, Double price,
      Integer minimumAge, Integer numUnits) {
    super(manufacturer, productName, price, minimumAge);
    this.numUnits = numUnits;
  }

  /**
   * Returns the number of units in a package.
   * @return the number of units
   */
  public Integer getNumUnits() {
    return this.numUnits;
  }

  /**
   * Adds this in given quantity to inventory.
   * @param quantity - number to add
   * @param inventory - inventory to add to
   */
  public void addToInventory(Integer quantity, Inventory inventory) {
    inventory.addHouseholdItem(this, quantity);
  }

  /**
   * Removes this from Inventory.
   * @param quantity number to remove
   * @param inventory inventory to remove from
   */
  public void removeFromInventory(Integer quantity, Inventory inventory) {
    inventory.removeHouseholdProduct(this, quantity);
  }

  /**
   * Gets a substitute for self from inventory.
   * @param inventory the inventory to search
   * @return the replacement produce
   * @throws SubstitutionNotFoundException If no subsutition is found
   */
  public AbstractProduct getSubstituteFromInventory(Inventory inventory)
      throws SubstitutionNotFoundException {
    return inventory.getHouseholdSubstitute(this);
  }

  /**
   * Checks inventory for stock of this.
   * @param quantity number to search for
   * @param inventory inventory to search
   * @return true if this is in stock in inventory
   */
  public boolean checkStockFromInventory(Integer quantity, Inventory inventory) {
    return inventory.checkHouseholdStock(this, quantity);
  }

  /**
   * Returns true if this is a valid subsutite for toReplace.
   * @param toReplace the item to compare
   * @return true if this is a valid product substitute
   */
  public boolean isValidSubstitute(AbstractHouseholdProduct toReplace) {
    return this.isSameType(toReplace) && this.getNumUnits() >= toReplace.getNumUnits()
        && this.getPrice() <= toReplace.getPrice();
  }

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
    if (!super.equals(other)) {
      return false;
    }
    AbstractHouseholdProduct that = (AbstractHouseholdProduct) other;
    return  numUnits.equals(that.numUnits) && manufacturer.equals(that.manufacturer)
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
    return Objects.hash(super.hashCode(), numUnits);
  }
}
