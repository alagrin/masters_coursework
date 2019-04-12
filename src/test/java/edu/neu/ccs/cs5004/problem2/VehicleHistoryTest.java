package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {

  private VehicleHistory hist;

  @Before
  public void setUp() throws Exception {
    this.hist = VehicleHistory.createNew();
    this.hist.addAccident(
        new Accident("2018-05-06", new Name("John", "Smith"), AccidentType.CRASH_NO_INJURY));
    this.hist
        .addViolation(new MovingViolation("2018-05-06", MovingViolationType.DISTRACTED_DRIVING));
  }

  @Test
  public void createNew() {
    this.hist = VehicleHistory.createNew();
    assertTrue(this.hist.getAccidents().size() == 0);
    assertTrue(this.hist.getViolations().size() == 0);
  }

  @Test
  public void getAccidents() throws IllegalDateFormat {
    List<Accident> accidents = this.hist.getAccidents();
    assertTrue(accidents.contains(
        new Accident("2018-05-06", new Name("John", "Smith"), AccidentType.CRASH_NO_INJURY)));
  }

  @Test
  public void getViolations() throws IllegalDateFormat {
    List<AbstractViolation> violations = this.hist.getViolations();
    assertTrue(violations
        .contains(new MovingViolation("2018-05-06", MovingViolationType.DISTRACTED_DRIVING)));
  }

  @Test
  public void addAccident() throws Exception {
    this.hist.addAccident(
        new Accident("2018-06-10", new Name("John", "Smith"), AccidentType.CRASH_INJURY));
    List<Accident> accidents = this.hist.getAccidents();
    assertTrue(accidents.contains(
        new Accident("2018-06-10", new Name("John", "Smith"), AccidentType.CRASH_INJURY)));
  }

  @Test
  public void addViolation() throws Exception {
    this.hist.addViolation(new NonMovingViolation("2018-05-06", NonMovingViolationType.PAPERWORK));
    List<AbstractViolation> violations = this.hist.getViolations();
    assertTrue(violations
        .contains(new NonMovingViolation("2018-05-06", NonMovingViolationType.PAPERWORK)));
  }

  @Test
  public void equalsSame() throws Exception {
    assertTrue(this.hist.equals(this.hist));
    VehicleHistory hist2 = VehicleHistory.createNew();
    hist2.addAccident(
        new Accident("2018-05-06", new Name("John", "Smith"), AccidentType.CRASH_NO_INJURY));
    hist2.addViolation(new MovingViolation("2018-05-06", MovingViolationType.DISTRACTED_DRIVING));
    assertEquals(hist, hist2);
  }

  @Test
  public void equalsDifferent() {
    assertFalse(this.hist.equals(null));
    VehicleHistory hist2 = VehicleHistory.createNew();
    assertNotEquals(hist, hist2);
  }

  @Test
  public void testHashCode() {
    assertEquals(hist.hashCode(), hist.hashCode());
    VehicleHistory hist2 = VehicleHistory.createNew();
    assertNotEquals(this.hist.hashCode(), hist2.hashCode());
  }

}