package edu.neu.ccs.cs5004.assignment7.problem1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {

  private StockItem<Salmon> salmonStock;
  private StockItem<PaperTowels> towelStock;

  @Before
  public void setUp() throws Exception {
    this.salmonStock = new StockItem<>(new Salmon("ocean", "king salmon", 19.99, 20.0), 10);
    this.towelStock =  new StockItem<>(new PaperTowels("store brand", "paper towels", 3.99, 2), 10);
  }

  @Test
  public void testGetProduct() {
    Salmon salmonProduct = salmonStock.getProduct();
    assertTrue(salmonProduct.equals(new Salmon("ocean", "king salmon", 19.99, 20.0)));
  }

  @Test
  public void testGetQuantity() {
    assertTrue(this.salmonStock.getQuantity().equals(10));
    assertTrue(this.towelStock.getQuantity().equals(10));
  }

  @Test
  public void testCheckQuantityTrue() {
    assertTrue(this.salmonStock.checkQuantity(5));
    assertTrue(this.towelStock.checkQuantity(5));
  }

  @Test
  public void testCheckQuantityFalse() {
    assertFalse(this.salmonStock.checkQuantity(15));
    assertFalse(this.towelStock.checkQuantity(11));
  }

  @Test
  public void testCheckQuantityTrueEdge() {
    assertTrue(this.salmonStock.checkQuantity(10));
    assertTrue(this.towelStock.checkQuantity(10));
  }

  @Test
  public void reduceQuantityValid() {
    try {
      this.salmonStock.reduceQuantity(6);
    } catch (OutOfStockException e) {
      fail();
    }
    assertTrue(this.salmonStock.getQuantity().equals(4));
  }

  @Test
  public void reduceQuantityException() {
    try {
      this.salmonStock.reduceQuantity(11);
      fail("expected exception");
    } catch (OutOfStockException e) {
    }
  }

}