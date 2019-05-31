package edu.neu.ccs.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShampooTest {
  private Shampoo shampoo;

  @Before
  public void setUp() throws Exception {
    this.shampoo = new Shampoo("loreal", "scented", 4.00, 12);
  }

  @Test
  public void testEqualsNull() {
    assertNotEquals(shampoo, null);

  }

  @Test
  public void testEqualsSame() {
    Shampoo shampoo1 = new Shampoo("loreal", "scented", 4.00, 12);
    assertEquals(shampoo, shampoo1);

  }
}