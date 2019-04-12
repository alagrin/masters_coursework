package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * The customer, their information, and current cart if any.
 */
public class Customer {
  private Name name;
  private Integer age;
  private ShoppingCart cart;

  /**
   * Creates a customer with their cart.
   * @param name customer name.
   * @param age customer age.
   * @param cart current customer's cart.
   */
  public Customer(Name name, Integer age, ShoppingCart cart) {
    this.name = name;
    this.age = age;
    this.cart = cart;
  }

  /**
   * Gets the full name of the customer.
   * @return the customer name object
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Gets age of customer.
   * @return the age
   */
  public Integer getAge() {
    return this.age;
  }

  /**
   * Gets the customer's shopping cart.
   * @return the cart, being null if empty or containing a list of products
   */
  public ShoppingCart getCart() {
    return this.cart;
  }

  /**
   * Sets the age of the customer.
   * @param age the age
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  /**
   * returns true is this equals other.
   * @param other the object to compare
   * @return true if objects are the same
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Customer customer = (Customer) other;
    return Objects.equals(name, customer.name)
        && Objects.equals(age, customer.age)
        && Objects.equals(cart, customer.cart);
  }

  /**
   * returns a numerical represesntation of the object.
   * @return a number representing the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age, cart);
  }
}
