package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OnlineStoreTest {

  private Inventory testInventory = new Inventory();
  private ShoppingCart testCart = new ShoppingCart();

  @Before
  public void setUp() throws RuntimeException {
    testInventory.addItem(new Cheese("darigold", "cheddar", 3.00, 10.0), 2);
    testInventory.addItem(new Salmon("oceana", "king", 4.00, 12.0), 2);
    this.testInventory.addItem(new PaperTowels("downy", "XL towel", 2.00, 2), 2);
    this.testInventory.addItem(new Shampoo("loreal", "scented", 4.00, 12), 2);
    this.testCart.getCartItems().add(new Cheese("darigold", "cheddar", 3.00, 10.0));
    this.testCart.getCartItems().add(new Salmon("oceana", "king", 4.00, 12.0));
  }

  private Customer testCustomer = new Customer(new Name("John", "Smith"), 26, this.testCart);
  private OnlineStore testStore = new OnlineStore(testInventory);
  private Order testOrder = testStore.fulfillOrder(testCustomer);

  @Test
  public void fulfillOrder() {
    AbstractProduct itemToCheck = new Cheese("darigold", "cheddar", 3.00, 10.0);
    Order newOrder = this.testStore.fulfillOrder(this.testCustomer);
    Assert.assertNotNull(newOrder);
    Assert.assertSame(this.testCustomer, newOrder.getCustomer());
    Assert.assertTrue(this.testInventory.checkStock(itemToCheck, 1));
    Assert.assertEquals(newOrder.getStatus(), OrderStatus.FULFILLED);
  }

  @Test
  public void processOrder() {
    Receipt testReceipt = testStore.processOrder(this.testCustomer, this.testOrder);
    List<AbstractProduct> recieved = testReceipt.getItemsReceived();
    List<AbstractProduct> outOfStock = testReceipt.getItemsOutOfStock();
    List<AbstractProduct> removed = testReceipt.getRemovedItems();
    Assert.assertTrue((recieved.contains(new Cheese("darigold", "cheddar", 3.00, 10.0))));
    Assert.assertTrue((recieved.contains(new Salmon("oceana", "king", 4.00, 12.0))));
    Assert.assertTrue(outOfStock.isEmpty());
    Assert.assertTrue(removed.isEmpty());
    Assert.assertEquals(testReceipt.getTotalCostOfOrder(), 7, 0);
  }

  @Test
  public void processOrderRemove() {
    this.testCart.getCartItems().add(new Beer("coors", "light",3.00, 12.0));
    this.testCart.getCartItems().add(new Shampoo("dawn", "idk", 0.0, 12));
    testCustomer = new Customer(new Name("John", "Smith"), 5, this.testCart);
    testInventory.addItem(new Beer("coors", "light",3.00, 12.0), 2);
    testStore = new OnlineStore(testInventory);
    Order testOrder = testStore.fulfillOrder(testCustomer);;
    Receipt testReceipt = testStore.processOrder(this.testCustomer, testOrder);
    List<AbstractProduct> recieved = testReceipt.getItemsReceived();
    List<AbstractProduct> outOfStock = testReceipt.getItemsOutOfStock();
    List<AbstractProduct> removed = testReceipt.getRemovedItems();
    Assert.assertTrue((recieved.contains(new Cheese("darigold", "cheddar", 3.00, 10.0))));
    Assert.assertTrue((recieved.contains(new Salmon("oceana", "king", 4.00, 12.0))));
    Assert.assertTrue(outOfStock.contains((new Shampoo("dawn", "idk", 0.0, 12))));
    Assert.assertTrue(removed.contains((new Beer("coors", "light",3.00, 12.0))));
    Assert.assertEquals(testReceipt.getTotalCostOfOrder(), 7, 0);
  }

  @Test
  public void getCurrentInventory() {
    Assert.assertEquals(this.testInventory, this.testStore.getCurrentInventory());
  }

}