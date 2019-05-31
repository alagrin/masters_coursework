package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manages the interaction between customer, cart, and inventory.
 */
public class OnlineStore {

  private IInventory currentInventory;

  /**
   * Instance of current store.
   * @param currentInventory currently available inventory of items
   */
  public OnlineStore(Inventory currentInventory) {
    this.currentInventory = currentInventory;
  }


  /**
   * Order is wrapper for processing shopping cart.
   * @param customer customer who's order is being fulfilled
   * @return the order, fulfilled back to the customer
   */
  public Order fulfillOrder(Customer customer) {
    List<AbstractProduct> removed = new ArrayList<>();
    Iterator<AbstractProduct> iter = productList(customer).iterator();
    while (iter.hasNext()) {
      AbstractProduct item = iter.next();
      if (!currentInventory.checkStock(item, 1)) {
        AbstractProduct replacement;
        try {
          replacement = currentInventory.getSubstitute(item);
          customer.getCart().getCartItems().add(replacement);
        } catch (SubstitutionNotFoundException e) {
          iter.remove();
          removed.add(item);
        }
      }
    }
    Order newOrder = new Order(customer, removed);
    newOrder.setStatus(OrderStatus.FULFILLED);
    return newOrder;
  }





  /**
   * Processes order w/ update to inventory, generates receipt accordingly.
   * @param customer the customer who is ordering
   * @param currentOrder current customer's order
   * @return a receipt with lists of information and total cost
   */
  public Receipt processOrder(Customer customer, Order currentOrder) {
    List<AbstractProduct> removedItems = new ArrayList<>();
    List<AbstractProduct> itemsReceived = new ArrayList<>();
    Iterator<AbstractProduct> iterator = productList(customer).iterator();
    while (iterator.hasNext()) {
      AbstractProduct item = iterator.next();
      if (item.getMinimumAge() > customer.getAge()) {
        iterator.remove();
        removedItems.add(item);
      } else {
        itemsReceived.add(item);
      }
      this.currentInventory.removeItem(item, 1);
    }
    currentOrder.setStatus(OrderStatus.PROCESSED);
    Receipt receipt = new Receipt(itemsReceived, currentOrder.getoutOfStock(), removedItems);
    return receipt;
  }


  /**
   * Gets current inventory.
   * @return list of products in inventory
   */
  public IInventory getCurrentInventory() {
    return this.currentInventory;
  }

  /**
   * Generates list of products in the customer's cart - utility method.
   * @param customer customer we are checking out
   * @return the list of items in customer's cart
   */
  private List<AbstractProduct> productList(Customer customer) {
    ShoppingCart customerCart = customer.getCart();
    return customerCart.getCartItems();
  }
}
