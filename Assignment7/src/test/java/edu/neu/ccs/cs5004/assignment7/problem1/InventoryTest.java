package edu.neu.ccs.cs5004.assignment7.problem1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
  private Inventory inv;
  @Before
  public void setUp() throws RuntimeException {
    this.inv = new Inventory();
    this.inv.addItem(new Cheese("darigold", "cheddar", 3.00, 10.0), 2);
    this.inv.addItem(new Salmon("oceana", "king", 4.00, 12.0), 2);
    this.inv.addItem(new Beer("georgetown", "mannys", 8.00, 12.0), 2);
    this.inv.addItem(new PaperTowels("downy", "XL towel", 2.00, 2), 2);
    this.inv.addItem(new Shampoo("loreal", "scented", 4.00, 12), 2);
  }

  @Test
  public void testAddGrocery() {
    this.inv.addItem(new Beer("coors", "light", 2.00, 12.0),2);
    assertTrue(this.inv.checkStock(new Beer("coors", "light", 2.00, 12.0), 1));
  }

  @Test
  public void testAddHousehold() {
    this.inv.addItem(new Shampoo("dawn", "unscented", 4.00, 12), 2);
    assertTrue(this.inv.checkStock(new Shampoo("dawn", "unscented", 4.00, 12), 1));
  }

  @Test
  public void testAddAbstract() {
    AbstractProduct prod = new Shampoo("dawn", "unscented", 4.00, 12);
    this.inv.addItem(prod, 2);
    assertTrue(this.inv.checkStock(new Shampoo("dawn", "unscented", 4.00, 12), 1));
  }

  @Test
  public void getTotalCost() {
    assertTrue(this.inv.getTotalCost() == 42.0);
  }

  @Test
  public void getSubstituteHouseholdValid() {
    this.inv.addItem(new Shampoo("loreal", "unscented", 2.00, 12), 2);
    this.inv.removeItem(new Shampoo("loreal", "scented", 4.00, 12), 2);
    try {
      AbstractProduct result = this.inv.getSubstitute(new Shampoo("loreal", "scented", 4.00, 12));
      assertTrue(result.equals(new Shampoo("loreal", "unscented", 2.00, 12)));
    } catch (SubstitutionNotFoundException e) {
      fail();
    }
  }

  @Test
  public void getSubstituteAbstractValid() {
    this.inv.addItem(new Shampoo("loreal", "unscented", 2.00, 12), 2);
    this.inv.removeItem(new Shampoo("loreal", "scented", 4.00, 12), 2);
    AbstractProduct prod = new Shampoo("loreal", "scented", 4.00, 12);
    try {
      AbstractProduct result = this.inv.getSubstitute(prod);
      assertTrue(result.equals(new Shampoo("loreal", "unscented", 2.00, 12)));
    } catch (SubstitutionNotFoundException e) {
      fail();
    }
  }

  @Test
  public void getSubstituteHousehouldInvalid() {
    this.inv.removeItem(new Shampoo("loreal", "scented", 4.00, 12), 2);
    try {
      AbstractProduct result = this.inv.getSubstitute(new Shampoo("loreal", "scented", 4.00, 12));
      fail("expected exception");
    } catch (SubstitutionNotFoundException e) {
    }
  }

  @Test
  public void getSubstituteGroceryValid() {
    this.inv.addItem(new Cheese("store brand", "blue", 2.00, 12.0), 2);
    this.inv.removeItem(new Cheese("darigold", "cheddar", 3.00, 10.0), 2);
    try {
      AbstractProduct result = this.inv.getSubstitute(new Cheese("darigold", "cheddar", 3.00, 10.0));
      assertTrue(result.equals(new Cheese("store brand", "blue", 2.00, 12.0)));
    } catch(SubstitutionNotFoundException e) {
      fail();
    }
  }

  @Test
  public void getSubstituteGroceryInvalid() {
    this.inv.removeItem(new Cheese("darigold", "cheddar", 3.00, 10.0), 2);
    try {
      AbstractProduct result = this.inv.getSubstitute(new Cheese("darigold", "cheddar", 3.00, 10.0));
      fail("expected exception");
    } catch (SubstitutionNotFoundException e) {
    }
  }

  @Test
  public void checkStockHouseholdInStock() {
    assertTrue(this.inv.checkStock(new PaperTowels("downy", "XL towel", 2.00, 2), 1));
  }

  @Test
  public void checkStockHouseholdOutStock() {
    assertFalse(this.inv.checkStock(new PaperTowels("storebrand", "generic", 2.00, 2), 1));
  }

  @Test
  public void checkStockGroceryInStock() {
    assertTrue(this.inv.checkStock(new Beer("georgetown", "mannys", 8.00, 12.0), 1));
  }

  @Test
  public void checkStockGroceryOutStock() {
    assertFalse(this.inv.checkStock(new Salmon("silver", "generic", 12.00, 2.0), 1));
  }

  @Test
  public void checkStockGroceryInStockTooMany() {
    assertFalse(this.inv.checkStock(new Beer("georgetown", "mannys", 8.00, 12.0), 3));
  }


  @Test
  public void removeItemGrocery() {
    this.inv.removeItem(new Cheese("darigold", "cheddar", 3.00, 10.0), 1);
    assertFalse(this.inv.checkStock(new Cheese("darigold", "cheddar", 3.00, 10.0), 2));
  }

  @Test
  public void removeItemHousehold() {
    this.inv.removeItem(new PaperTowels("downy", "XL towel", 2.00, 2), 1);
    assertFalse(this.inv.checkStock(new PaperTowels("downy", "XL towel", 2.00, 2), 2));
  }
}