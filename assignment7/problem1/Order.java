package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.List;

/**
 * Order represents the customer/customer's cart and order status together. Order is a wrapper
 * created to allow us to track the order/cart through the processes.
 */
public class Order {

  private OrderStatus status;
  private List<AbstractProduct> outOfStock;
  private Customer customer;

  /**
   * The instance of the customer/their order, started with a pending status.
   * @param customer the customer who's cart we are examining
   */
  public Order(Customer customer, List<AbstractProduct> removedItems) {
    this.customer = customer;
    this.outOfStock = removedItems;
    status = OrderStatus.PENDING;
  }

  /**
   * returns the removed items.
   * @return the removed items;
   */
  public List<AbstractProduct> getoutOfStock() {
    return outOfStock;
  }

  /**
   * Gets the current customer.
   * @return the customer involved in the transaction
   */
  public Customer getCustomer() {
    return this.customer;
  }

  /**
   * Gets the status of the current order.
   * @return current OrderStatus type
   */
  public OrderStatus getStatus() {
    return this.status;
  }

  /**
   * Sets the status as the order moves through the checkout process.
   * @param updatedStatus status of current order
   */
  public void setStatus(OrderStatus updatedStatus) {
    this.status = updatedStatus;
  }
}
