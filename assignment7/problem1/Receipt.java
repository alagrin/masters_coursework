package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.List;

/**
 * The basic receipt with lists of items and order price.
 */
public class Receipt {


  private List<AbstractProduct> itemsReceived;
  private List<AbstractProduct> itemsOutOfStock;
  private List<AbstractProduct> removedItems;

  /**
   * Creates a new receipt.
   * @param itemsReceived list of items received
   * @param itemsOutOfStock list of out of stock items
   * @param removedItems list of items taken out of order
   */
  public Receipt(  List<AbstractProduct> itemsReceived,
      List<AbstractProduct> itemsOutOfStock,
      List<AbstractProduct> removedItems) {
    this.itemsReceived = itemsReceived;
    this.itemsOutOfStock = itemsOutOfStock;
    this.removedItems = removedItems;
  }

  /**
   * Provides total cost of finalized order.
   * @return an amount representing the total value of the cart
   */
  public double getTotalCostOfOrder() {
    double total = 0;
    for (AbstractProduct item :
        this.itemsReceived) {
      total += item.getPrice();
    }
    return total;
  }

  /**
   * Returns the items removed.
   * @return the list of removed items
   */
  public List<AbstractProduct> getItemsReceived() {
    return this.itemsReceived;
  }

  /**
   * returns a list of items that where out of stock.
   * @return the list of items that were out of stock
   */
  public List<AbstractProduct> getItemsOutOfStock() {
    return this.itemsOutOfStock;
  }

  /**
   * returns a list of items that were removed for other reasons.
   * @return a list of returned items
   */
  public List<AbstractProduct> getRemovedItems() {
    return this.removedItems;
  }

  /**
   * provides a string representation of the item.
   * @return a string of the item.
   */
  @Override
  public String toString() {
    return "Receipt{"
        + "itemsReceived=" + itemsReceived
        + ", itemsOutOfStock=" + itemsOutOfStock
        + ", removedItems=" + removedItems
        + '}';
  }
}
