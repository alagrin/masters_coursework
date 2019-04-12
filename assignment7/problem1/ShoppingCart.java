package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart contains the current items Customer has added.
 */
class ShoppingCart {

  private List<AbstractProduct> cartItems;

  /**
   * Represents the shopping cart and its contents.
   */
  public ShoppingCart() {
    this.cartItems = new ArrayList<>();
  }

  /**
   * Calculates total cost of items in the cart.
   * @return the amount due for items in cart
   */
  public double calcTotalCost() {
    // will have to count repetition of a product in cart
    double total = 0;
    for (AbstractProduct item :
        this.cartItems) {
      total += item.getPrice();
    }
    return total;
  }

  /**
   * Clears the cart contents.
   */
  public void emptyCart() {
    this.cartItems.clear();
    this.cartItems =  new ArrayList<>();
  }

  /**
   * Gets the cart items.
   * @return a list of items.
   */
  public List<AbstractProduct> getCartItems() {
    return this.cartItems;
  }

}
