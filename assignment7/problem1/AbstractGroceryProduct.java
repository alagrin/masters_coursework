package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Class containing shared state information for Grocery Products.
 */

public abstract class AbstractGroceryProduct extends AbstractProduct {

  protected Double weightInOunces;


  /**
   * Creates a new grocery product with a minimum age.
   * @param manufacturer the manufacturers name
   * @param productName the product name
   * @param price the price
   * @param minimumAge the minimum age
   * @param weightInOunces the weight of the product
   */
  public AbstractGroceryProduct(String manufacturer, String productName, Double price,
      Integer minimumAge, Double weightInOunces) {
    super(manufacturer, productName, price, minimumAge);
    this.weightInOunces = weightInOunces;
  }

  /**
   * Creates a new grocery product with no minimum age.
   * @param manufacturer the manufacturers name
   * @param productName the product name
   * @param price the price
   * @param weightInOunces the weight of the product
   */
  public AbstractGroceryProduct(String manufacturer, String productName, Double price,
      Double weightInOunces) {
    super(manufacturer, productName, price);
    this.weightInOunces = weightInOunces;
  }

  /**
   * Adds self in given quantity to inventory.
   * @param quantity - number to add
   * @param inventory - inventory to add to
   */
  public void addToInventory(Integer quantity, Inventory inventory) {
    inventory.addGroceryItem(this, quantity);
  }

  /**
   * Removes self from Inventory.
   * @param quantity number to remove
   * @param inventory inventory to remove from
   */
  public void removeFromInventory(Integer quantity, Inventory inventory) {
    inventory.removeGroceryProduct(this, quantity);
  }

  /**
   * Gets a subsutite for self from inventory .
   * @param inventory the inventory to search
   * @return the replacement produce
   * @throws SubstitutionNotFoundException If no subsutition is found
   */
  public AbstractProduct getSubstituteFromInventory(Inventory inventory)
      throws SubstitutionNotFoundException {
    return inventory.getGrocerySubstitute(this);
  }

  /**
   * Checks inventory for stock of this.
   * @param quantity number to search for
   * @param inventory inventory to search
   * @return true if this is in stock in inventory
   */
  public boolean checkStockFromInventory(Integer quantity, Inventory inventory) {
    return inventory.checkGroceryStock(this, quantity);
  }

  /**
   * Returns true if this is a valid substitute for toReplace.
   * @param toReplace the item to compare
   * @return true if this is a valid product substitute
   */
  public boolean isValidSubstitute(AbstractGroceryProduct toReplace) {
    return this.isSameType(toReplace) && this.getWeight() >= toReplace.getWeight()
        && this.getPrice() <= toReplace.getPrice();
  }

  /**
   * returns the weight of the product in ounces.
   * @return the weight in ounces
   */
  public Double getWeight() {
    return this.weightInOunces;
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
    AbstractGroceryProduct that = (AbstractGroceryProduct) other;
    return weightInOunces.equals(that.weightInOunces) && manufacturer.equals(that.manufacturer)
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
    return Objects.hash(super.hashCode(), weightInOunces);
  }
}
