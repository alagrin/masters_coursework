package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NonMovingViolationTest {

  private NonMovingViolation violation;

  @Before
  public void setUp() throws Exception {
    this.violation = new NonMovingViolation("2018-05-06", NonMovingViolationType.PAPERWORK);
  }

  @Test
  public void isDisqualifying() {
    assertFalse(violation.isDisqualifying());
  }

  @Test
  public void getNonMovingViolationType() {
    assertTrue(this.violation.getNonMovingViolationType() == NonMovingViolationType.PAPERWORK);
  }

  @Test
  public void equalsSame() throws IllegalDateFormat {
    assertEquals(violation, violation);
    assertEquals(violation, new NonMovingViolation("2018-05-06", NonMovingViolationType.PAPERWORK));
  }

  @Test
  public void equalsDifferent() throws IllegalDateFormat {
    assertNotEquals(violation,
        new NonMovingViolation("2018-05-06", NonMovingViolationType.PARKING));
  }

  @Test
  public void equalsDifferent2() throws IllegalDateFormat {
    assertNotEquals(violation,
        new NonMovingViolation("2018-06-06", NonMovingViolationType.PAPERWORK));
  }

  @Test
  public void testHashCode() throws IllegalDateFormat {
    assertTrue(this.violation.hashCode() == this.violation.hashCode());
    assertNotEquals(this.violation.hashCode(),
        new NonMovingViolation("2018-06-06", NonMovingViolationType.PAPERWORK));
  }
}