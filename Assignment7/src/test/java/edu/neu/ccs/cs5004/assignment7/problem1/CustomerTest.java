package edu.neu.ccs.cs5004.assignment7.problem1;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
  private ShoppingCart testCart = new ShoppingCart();
  private Customer testCustomer = new Customer(new Name("John", "Smith"), 26, this.testCart);

  @Test
  public void getName() {
    Assert.assertNotNull(this.testCustomer.getName());
    Assert.assertEquals(this.testCustomer.getName().getFirst(), "John");
    Assert.assertEquals(this.testCustomer.getName().getLast(), "Smith");
  }

  @Test
  public void getAge() {
    Assert.assertNotNull(this.testCustomer.getAge());
    Assert.assertEquals(this.testCustomer.getAge(), 26, 0);
  }

  @Test
  public void getCart() {
    Assert.assertNotNull(this.testCustomer.getCart());
    Assert.assertSame(this.testCustomer.getCart(), this.testCart);
  }

  @Test
  public void setAge() {
    this.testCustomer.setAge(30);
    Assert.assertEquals(this.testCustomer.getAge(), 30, 0);
  }
}