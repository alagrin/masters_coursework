package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {

  private DriverHistory history;
  private DriverHistory historyNonDisqualifying;

  @Before
  public void setUp() throws Exception {
    this.history = DriverHistory.createNew();
    this.history.add(new MovingViolation("2018-5-6", MovingViolationType.DUI));
    this.history.add(new NonMovingViolation("2016-5-6", NonMovingViolationType.PAPERWORK));
    this.historyNonDisqualifying = DriverHistory.createNew();
    this.historyNonDisqualifying
        .add(new NonMovingViolation("2016-5-6", NonMovingViolationType.PAPERWORK));
    this.historyNonDisqualifying
        .add(new MovingViolation("2015-5-6", MovingViolationType.DISTRACTED_DRIVING));
  }

  @Test
  public void getMovingViolations() throws IllegalDateFormat {
    assertTrue(this.history.getMovingViolations()
        .contains(new MovingViolation("2018-5-6", MovingViolationType.DUI)));
  }

  @Test
  public void getNonMovingViolations() throws IllegalDateFormat {
    assertTrue(this.history.getNonMovingViolations().contains(new NonMovingViolation("2016-5-6",
        NonMovingViolationType.PAPERWORK)));
  }

  @Test
  public void containsDisqualifyingViolation() {
    assertTrue(this.history.containsDisqualifyingViolation());
    assertFalse(this.historyNonDisqualifying.containsDisqualifyingViolation());
  }

  @Test
  public void addMoving() throws IllegalDateFormat {
    this.history.add(new MovingViolation("2016-5-6", MovingViolationType.RECKLESS_DRIVING));
    assertTrue(this.history.getMovingViolations()
        .contains(new MovingViolation("2016-5-6", MovingViolationType.RECKLESS_DRIVING)));
  }

  @Test
  public void addNonMoving() throws IllegalDateFormat {
    this.history.add(new NonMovingViolation("2018-5-6", NonMovingViolationType.PARKING));
    assertTrue(this.history.getNonMovingViolations()
        .contains(new NonMovingViolation("2018-5-6", NonMovingViolationType.PARKING)));
  }

  @Test
  public void equalsSame() throws IllegalDateFormat {
    DriverHistory newHistory = DriverHistory.createNew();
    newHistory.add(new MovingViolation("2018-5-6", MovingViolationType.DUI));
    newHistory.add(new NonMovingViolation("2016-5-6", NonMovingViolationType.PAPERWORK));
    assertEquals(this.history, this.history);
    assertEquals(this.history, newHistory);
  }

  @Test
  public void equalsDifferent() throws IllegalDateFormat {
    DriverHistory newHistory = DriverHistory.createNew();
    newHistory.add(new MovingViolation("2018-5-6", MovingViolationType.DISTRACTED_DRIVING));
    newHistory.add(new NonMovingViolation("2016-5-6", NonMovingViolationType.PARKING));
    assertNotEquals(this.history, newHistory);
    assertNotEquals(this.history, null);
    assertNotEquals(this.history, DriverHistory.createNew());
  }

  @Test
  public void testHashCode() {
    assertNotEquals(this.history, this.historyNonDisqualifying);
    assertEquals(this.history, this.history);
  }


}