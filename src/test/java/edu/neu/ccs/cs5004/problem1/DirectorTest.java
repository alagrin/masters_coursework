package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem2.Name;
import org.junit.Assert;
import org.junit.Test;

public class DirectorTest {
  private Name name = new Name("Tim", "Burton");
  private Director director = new Director(this.name);
  private Director director2 = new Director(this.name);

  @Test
  public void getFirstName() {
    Assert.assertEquals(name, this.director.getName());
  }

  @Test
  public void testEquals() {
    Assert.assertNotEquals(name, director);
    Assert.assertEquals(director, director);
    Assert.assertEquals(director, director2);
  }

  @Test
  public void getStringDirector() {
    Assert.assertEquals("Director: Tim Burton", this.director.toString());
  }
}