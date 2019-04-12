package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name name;

  @Before
  public void setUp() throws Exception {
    this.name = new Name("john", "smith");
  }

  @Test
  public void getFirst() {
    assertEquals("john", this.name.getFirst());
  }

  @Test
  public void getLast() {
    assertEquals("smith", this.name.getLast());
  }

  @Test
  public void equalsValid() {
    assertTrue(name.equals(name));
    assertTrue(name.equals(new Name("john", "smith")));
  }

  @Test
  public void equalsInvalid() {
    assertFalse(name.equals(null));
    assertFalse(name.equals(new Name("john", "ryan")));
  }

  @Test
  public void testHashCode() {
    Name name2 = new Name("john", "smith");
    Date date = new Date(1991, 2, 5);
    assertEquals(name.hashCode(), name2.hashCode());
  }
}