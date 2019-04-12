package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AccidentTest {

  private Accident accident1;
  private Accident accident2;

  @Before
  public void setUp() throws Exception {
    this.accident1 = new Accident("2018-5-6", new Name("john", "smith"), AccidentType.CRASH_NO_INJURY);
    this.accident2 = new Accident("2016-1-1", new Name("john", "smith"), AccidentType.CRASH_INJURY);
  }

  @Test
  public void getDate() {
    assertEquals(new Date(118,4,6), accident1.getDate());
  }

  @Test
  public void getAtFaultDriver() {
    assertEquals(new Name("john", "smith"), this.accident1.getAtFaultDriver());
  }

  @Test
  public void getAccidentType() {
    assertEquals(AccidentType.CRASH_INJURY, this.accident2.getAccidentType());
  }

  @Test
  public void testequals() {
    assertEquals(accident1,accident1);
    assertNotEquals(accident2,accident1);

  }

  @Test
  public void testhashCode() {
    assertEquals(accident1.hashCode(),accident1.hashCode());
    assertNotEquals(accident2.hashCode(),accident1.hashCode());
  }
}