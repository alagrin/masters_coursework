package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class MovingViolationTest {

  private MovingViolation violationDQ;
  private MovingViolation violation;

  @Before
  public void setUp() throws Exception {
    this.violation = new MovingViolation("2018-05-06",
        MovingViolationType.DISTRACTED_DRIVING);
    this.violationDQ = new MovingViolation("2018-05-06",
        MovingViolationType.DUI);
  }

  @Test
  public void getDateOfViolation() {
    assertEquals(new Date(118, 4, 6), this.violation.getDateOfViolation());
  }

  @Test
  public void getViolationType() {
    assertTrue(this.violation.getViolationType() == ViolationType.MOVING);
  }

  @Test
  public void getMovingViolationTypeType() {
    assertTrue(
        this.violation.getMovingViolationTypeType() == MovingViolationType.DISTRACTED_DRIVING);
  }

  @Test
  public void isDisqualifying() {
    assertTrue(violationDQ.isDisqualifying());
    assertFalse(violation.isDisqualifying());
  }

  @Test
  public void equalsNotEqual() throws IllegalDateFormat {
    assertFalse(this.violationDQ.equals(this.violation));
    assertFalse(this.violationDQ
        .equals(new NonMovingViolation("2018-2-15", NonMovingViolationType.PAPERWORK)));
  }

  @Test
  public void equalsSame() throws IllegalDateFormat {
    assertTrue(this.violationDQ.equals(this.violationDQ));
    assertTrue(this.violationDQ.equals(new MovingViolation("2018-05-06",
        MovingViolationType.DUI)));
  }

  @Test
  public void testhashCode() {
    assertTrue(this.violationDQ.hashCode() == this.violationDQ.hashCode());
    assertNotEquals(this.violationDQ.hashCode(), this.violation.hashCode());
  }
}