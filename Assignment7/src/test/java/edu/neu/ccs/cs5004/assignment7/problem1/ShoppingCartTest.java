package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
  private ShoppingCart testCart = new ShoppingCart();
  private ShoppingCart emptyTestCart = new ShoppingCart();
  private AbstractProduct itemToAdd = new Cheese("DariGold", "cheddar", 3.55, 10.0);
  private AbstractProduct anotherItem = new Shampoo("loreal", "scented", 4.00, 12);

  @Before
  public void setUp() {
    this.testCart.getCartItems().add(itemToAdd);
    this.testCart.getCartItems().add(anotherItem);
  }

  @Test
  public void calcTotalCost() {
    Assert.assertEquals(this.testCart.calcTotalCost(), 7.55, 0);
    Assert.assertEquals(this.emptyTestCart.calcTotalCost(), 0, 0);
  }

  @Test
  public void emptyCart() {
    this.testCart.emptyCart();
    Assert.assertEquals(this.testCart.getCartItems(), new ArrayList<AbstractProduct>());
  }

  @Test
  public void getCartItems() {
    Assert.assertNotNull(this.testCart.getCartItems());
    Assert.assertTrue(this.testCart.getCartItems().contains(itemToAdd));
    Assert.assertTrue(this.testCart.getCartItems().contains(anotherItem));
  }
}