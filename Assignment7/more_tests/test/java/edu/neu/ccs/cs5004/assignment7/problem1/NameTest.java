package edu.neu.ccs.cs5004.assignment7.problem1;

import org.junit.Assert;
import org.junit.Test;

public class NameTest {
  private Name testName = new Name("John", "Smith");

  @Test
  public void getFirst() {
    Assert.assertEquals(this.testName.getFirst(), "John");
    Assert.assertNotNull(this.testName.getFirst());
  }

  @Test
  public void setFirst() {
    this.testName.setFirst("Alan");
    Assert.assertNotNull(this.testName.getFirst());
    Assert.assertEquals(this.testName.getFirst(), "Alan");
  }

  @Test
  public void getLast() {
    Assert.assertEquals(this.testName.getLast(), "Smith");
  }

  @Test
  public void setLast() {
    this.testName.setLast("Rogers");
    Assert.assertEquals(this.testName.getLast(), "Rogers");
  }
}