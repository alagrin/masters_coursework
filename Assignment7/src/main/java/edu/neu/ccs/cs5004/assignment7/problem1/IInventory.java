package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * The supported operations for an inventory.
 */

public interface IInventory {


  /**
   * Returns the total cost of the Inventory.
   * @return the total cost of all items
   */
  Double getTotalCost();

  /**
   * Adds a new item to the inventory.
   * @param itemToAdd the product to add
   */
  void addItem(AbstractProduct itemToAdd, Integer quantity);

  /**
   * Returns a product that can replace.
   * @param toReplace the product to replace
   * @return the product found to replace the item
   * @throws SubstitutionNotFoundException if no suitable substitute is found
   *
   */
  AbstractProduct getSubstitute(AbstractProduct toReplace) throws SubstitutionNotFoundException;

  /**
   * returns true if product is in stock in the desired quantity.
   * @param product the product to search for
   * @param quantityToCheck the number of items to search for
   * @return if the quantity of product is in stock
   */
  boolean checkStock(AbstractProduct product, Integer quantityToCheck);

  /**
   * Removes quantity of product toRemove.
   * @param toRemove product to remove
   * @param quantityToRemove number of items to remove
   */
  void removeItem(AbstractProduct toRemove, Integer quantityToRemove);
}


