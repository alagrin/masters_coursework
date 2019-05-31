package edu.neu.ccs.cs5004.assignment7.problem1;

// Keeps track of all items the store has in stock and allows operations on those items.


import java.util.ArrayList;
import java.util.List;

public class Inventory implements IInventory {

  private List<StockItem<AbstractHouseholdProduct>> householdProducts;
  private List<StockItem<AbstractGroceryProduct>> groceryProducts;

  private static final Integer NOT_FOUND_INDEX = -1;

  /**
   * Creates a new Inventory.
   */
  public Inventory() {
    this.householdProducts = new ArrayList<>();
    this.groceryProducts = new ArrayList<>();
  }

  /**
   * Returns the total cost of the Inventory.
   *
   * @return the total cost of all items
   */
  @Override
  public Double getTotalCost() {
    Double total = 0.0;
    for (StockItem item: this.householdProducts) {
      total += item.getQuantity() * item.getProduct().getPrice();

    }
    for (StockItem item: this.groceryProducts) {
      total += item.getQuantity() * item.getProduct().getPrice();
    }
    return total;
  }

  /**
   * Adds a new item to the inventory.
   * @param itemToAdd the product to add
   */
  public void addItem(AbstractProduct itemToAdd, Integer quantity) {
    itemToAdd.addToInventory(quantity, this);
  }

  /**
   * Returns a product that can replace.
   *
   * @param toReplace the product to replace
   * @return the product found to replace the item
   * @throws SubstitutionNotFoundException if no suitable substitute is found
   */
  @Override
  public AbstractProduct getSubstitute(AbstractProduct toReplace)
      throws SubstitutionNotFoundException {
    return toReplace.getSubstituteFromInventory(this);
  }

  /**
   * returns true if product is in stock in the desired quantity.
   *
   * @param product the product to search for
   * @param quantityToCheck the number of items to search for
   * @return if the quantity of product is in stock
   */
  @Override
  public boolean checkStock(AbstractProduct product, Integer quantityToCheck) {
    return product.checkStockFromInventory(quantityToCheck, this);
  }

  /**
   * Removes quantity of product toRemove.
   *
   * @param toRemove product to remove
   * @param quantityToRemove number of items to remove
   */
  @Override
  public void removeItem(AbstractProduct toRemove, Integer quantityToRemove) {
    toRemove.removeFromInventory(quantityToRemove, this);
  }

  /**
   * Adds a new item to the inventory.
   * @param itemToAdd the product to add
   */
  public void addHouseholdItem(AbstractHouseholdProduct itemToAdd, Integer quantity) {
    this.householdProducts.add(new StockItem<>(itemToAdd, quantity));
  }

  /**
   * Adds a new item to the inventory.
   * @param itemToAdd the product to add
   */

  public void addGroceryItem(AbstractGroceryProduct itemToAdd, Integer quantity) {
    this.groceryProducts.add(new StockItem<>(itemToAdd, quantity));
  }

  /**
   * Gets a valid substitute for given Household item.
   * @param toReplace item to replace
   * @return the valid substitute
   * @throws SubstitutionNotFoundException if no substitution is found
   */
  public AbstractProduct getHouseholdSubstitute(AbstractHouseholdProduct toReplace)
      throws SubstitutionNotFoundException  {
    for (StockItem<AbstractHouseholdProduct> item : this.householdProducts) {
      AbstractHouseholdProduct currentProduct = item.getProduct();
      if (currentProduct.isValidSubstitute(toReplace)  && this.checkStock(currentProduct, 1)) {
        return currentProduct;
      }
    }
    throw new SubstitutionNotFoundException("couldn't find replacement");

  }

  /**
   * Returns a product that can replace.
   *
   * @param toReplace the product to replace
   * @return the product found to replace the item
   */
  public AbstractProduct getGrocerySubstitute(AbstractGroceryProduct toReplace)
      throws SubstitutionNotFoundException {
    for (StockItem<AbstractGroceryProduct> item : this.groceryProducts) {
      AbstractGroceryProduct currentProduct = item.getProduct();
      if (currentProduct.isValidSubstitute(toReplace) && this.checkStock(currentProduct, 1)) {
        return currentProduct;
      }
    }
    throw new SubstitutionNotFoundException("couldn't find replacement");
  }

  /**
   * returns true if product is in stock in the desired quantity.
   *
   * @param product the product to search for
   * @param quantityToCheck the number of items to search for
   */
  public boolean checkGroceryStock(AbstractGroceryProduct product, Integer quantityToCheck) {
    int index = this.groceryProducts.indexOf(new StockItem<>(product,0));
    if (index == NOT_FOUND_INDEX) {
      return false;
    } else {
      return this.groceryProducts.get(index).checkQuantity(quantityToCheck);
    }
  }

  /**
   * returns true if product is in stock in the desired quantity.
   *
   * @param product the product to search for
   * @param quantityToCheck the number of items to search for
   */
  public boolean checkHouseholdStock(AbstractHouseholdProduct product, Integer quantityToCheck) {
    int index = this.householdProducts.indexOf(new StockItem<>(product,0));
    if (index == NOT_FOUND_INDEX) {
      return false;
    } else {
      return this.householdProducts.get(index).checkQuantity(quantityToCheck);
    }
  }

  /**
   * Removes quantity of product toRemove.
   *
   * @param toRemove product to remove
   * @param quantityToRemove number of items to remove
   */
  public void removeGroceryProduct(AbstractGroceryProduct toRemove, Integer quantityToRemove) {
    int index = this.groceryProducts.indexOf(new StockItem<>(toRemove,0));
    StockItem<AbstractGroceryProduct> currentProductent = this.groceryProducts.get(index);
    currentProductent.setQuantity(currentProductent.getQuantity() - quantityToRemove);
  }

  /**
   * Removes quantity of product toRemove.
   *
   * @param toRemove product to remove
   * @param quantityToRemove number of items to remove
   */
  public void removeHouseholdProduct(AbstractHouseholdProduct toRemove, Integer quantityToRemove) {
    int index = this.householdProducts.indexOf(new StockItem<>(toRemove,0));
    StockItem<AbstractHouseholdProduct> currentProductent = this.householdProducts.get(index);
    currentProductent.setQuantity(currentProductent.getQuantity() - quantityToRemove);
  }

}