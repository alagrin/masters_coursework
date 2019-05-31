package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
  private Inventory testInventory = new Inventory();
  private ShoppingCart testCart = new ShoppingCart();
  private Customer testCustomer = new Customer(new Name("John", "Smith"), 25, this.testCart);
  private Order initialOrder = new Order(this.testCustomer, new ArrayList<AbstractProduct>());

  @Before
  public void setUp() {
    AbstractProduct cheese = new Cheese("darigold", "cheddar", 3.00, 10.0);
    AbstractProduct shampoo = new Shampoo("loreal", "scented", 4.00, 12);

    testInventory.addItem(cheese, 1);
    testInventory.addItem(shampoo, 1);

    this.testCart.getCartItems().add(cheese);
    this.testCart.getCartItems().add(shampoo);
  }

  @Test
  public void getStatus() {
    Assert.assertEquals(initialOrder.getStatus(), OrderStatus.PENDING);
    Assert.assertNotEquals(initialOrder.getStatus(), OrderStatus.PROCESSED);
  }

  @Test
  public void getTestCustomer() {
    Assert.assertSame(initialOrder.getCustomer(), testCustomer);
  }
}