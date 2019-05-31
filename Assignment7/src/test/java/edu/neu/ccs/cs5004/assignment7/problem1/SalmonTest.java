package edu.neu.ccs.cs5004.assignment7.problem1;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SalmonTest {

  private Salmon king;

  @Before
  public void setUp() throws Exception {
    this.king = new Salmon("ocean", "king salmon", 19.99, 20.0);
  }

  @Test
  public void testGetWeightInOunces() {
    assertTrue(this.king.getWeight() == 20.0);
  }

  @Test
  public void testGetManufacturer() {
    assertTrue(this.king.getManufacturer().equals("ocean"));
  }

  @Test
  public void testGetProductName() {
    assertTrue(this.king.getProductName().equals("king salmon"));
  }

  @Test
  public void testGetPrice() {
    assertTrue(this.king.getPrice().equals(19.99));
  }

  @Test
  public void testGetMinimumAge() {
    assertTrue(this.king.getMinimumAge().equals(0));
  }


  @Test
  public void testEqualsSame() {
    assertTrue(this.king.equals(this.king));
    Salmon kingSame = new Salmon("ocean", "king salmon", 19.99, 20.0);
    assertTrue(this.king.equals(kingSame));
  }

  @Test
  public void testEqualsDifferent() {
    Salmon king2 = new Salmon("river", "silver salmon", 9.99, 10.0);
    Cheese cheese = new Cheese("darigold", "cheddar", 4.99, 10.0);
    assertFalse(this.king.equals(king2));
    assertFalse(this.king.equals(null));
    assertFalse(this.king.equals(cheese));
  }

  @Test
  public void testHashCodeSame() {
    assertTrue(this.king.hashCode()==this.king.hashCode());
    Salmon kingSame = new Salmon("ocean", "king salmon", 19.99, 20.0);
    assertTrue(this.king.hashCode()== kingSame.hashCode());
  }

  @Test
  public void testHashCodeDifferent() {
    Salmon king2 = new Salmon("river", "silver salmon", 9.99, 10.0);
    assertFalse(this.king.hashCode()== king2.hashCode());
  }

  @Test
  public void isSameTypeTrue() {
    Salmon king2 = new Salmon("river", "silver salmon", 9.99, 10.0);
    assertTrue(this.king.isSameType(king2));
  }

  @Test
  public void isSameTypeFalse() {
    Beer beer = new Beer("georgetown", "mannys", 6.99, 12.0);
    assertFalse(this.king.isSameType(beer));
    AbstractProduct beerProduct = new Beer("georgetown", "mannys", 6.99, 12.0);
    assertFalse(this.king.isSameType(beerProduct));
  }

  @Test
  public void testHashCode() {
    Beer beer = new Beer("georgetown", "mannys", 6.99, 12.0);
    assertFalse(beer.hashCode() == this.king.hashCode());
    assertTrue(this.king.hashCode() == this.king.hashCode());
  }

  @Test
  public void testAbstractEquals() {
    AbstractProduct beer = new Beer("georgetown", "mannys", 6.99, 12.0);
    AbstractProduct beer2 = new Beer("georgetown", "mannys", 6.99, 12.0);
    AbstractProduct salmon = this.king;
    assertTrue(beer.equals(beer2));
    assertFalse(beer.equals(salmon));
    assertFalse(beer.equals(null));
    assertFalse(beer.equals(this.king));
  }

  @Test
  public void testIsvalidSubstituteTrue() {
    Salmon silver = new Salmon("river", "silver salmon", 9.99, 20.0);
    assertTrue(silver.isValidSubstitute(this.king));
  }

  @Test
  public void testIsvalidSubstituteFalse() {
    Salmon silver = new Salmon("river", "silver salmon", 9.99, 10.0);
    assertFalse(silver.isValidSubstitute(this.king));
  }

  @Test
  public void testIsvalidSubstituteFalseTooExpensive() {
    Salmon silver = new Salmon("river", "silver salmon", 29.99, 10.0);
    assertFalse(silver.isValidSubstitute(this.king));
  }

  @Test
  public void testIsvalidSubstituteDifferentType() {
    Beer beer = new Beer("georgetown", "mannys", 6.99, 12.0);
    assertFalse(beer.isValidSubstitute(this.king));
  }
}