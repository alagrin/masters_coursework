package edu.neu.ccs.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeerTest {

  @Test
  public void getMinimumAge() {
    Beer mannys = new Beer("georgetown", "mannys", 6.99, 12.0);
    assertTrue(21 == mannys.getMinimumAge());
  }

  @Test
  public void testHashCode() {
    Beer mannys = new Beer("georgetown", "mannys", 6.99, 12.0);
    Beer coors = new Beer("coors", "light", 6.99, 12.0);
    assertTrue(mannys.hashCode() == mannys.hashCode());
    assertFalse(coors.hashCode() == mannys.hashCode());
  }
}