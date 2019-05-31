package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Represents a single item sold in the store and tracks its quantity.
 */
public class StockItem<T extends AbstractProduct> {

  private T product;
  private Integer quantity;

  /**
   * Creates a new StockItem.
   * @param product the product it represents
   * @param quantity the quantity of product
   */
  public StockItem(T product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * Returns the product this item represents.
   * @return the product being tracked
   */
  public T getProduct() {
    return this.product;
  }

  /**
   * Returns the number of units available for purchase.
   * @return the quantity available
   */
  public Integer getQuantity() {
    return this.quantity;
  }

  /**
   * Returns true if there are at least numToRemove items in stock.
   * @param numToRemove the number of items to check for
   * @return whether there are numToRemove in stock
   */
  public boolean checkQuantity(Integer numToRemove) {
    return this.quantity >= numToRemove;
  }

  /**
   * Removes items from stock after purchase.
   * @param numToRemove number of items to remove
   * @throws OutOfStockException if there aren't enough items in stock
   */
  public void reduceQuantity(Integer numToRemove) throws OutOfStockException {
    if (numToRemove > this.quantity) {
      throw new OutOfStockException("There are less than " + numToRemove + " items in stock");
    }
    this.quantity = this.quantity - numToRemove;
  }

  /**
   * Sets the quantity of the Stockitem.
   * @param quantity new quantity
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /**
   * Returns true if the two stock items contain the same product.
   * @param other the object to compare
   * @return true if objects are equal
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    StockItem<?> stockItem = (StockItem<?>) other;
    return product.equals(stockItem.product);
  }

  /**
   * returns a numeric representation of the object.
   * @return the numeric representation
   */
  @Override
  public int hashCode() {
    return Objects.hash(product, quantity);
  }
}
