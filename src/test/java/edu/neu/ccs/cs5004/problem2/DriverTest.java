package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

  private Driver d1;
  private Driver d2;

  @Before
  public void setUp() throws Exception {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    DriversLicense d2License = new DriversLicense("9876", new Name("joe", "smith"), "5678 1st",
        "1995-5-6", "MEX", "OR", "2006-4-10", "2021-4-10");
    this.d1 = new Driver(new Name("john", "smith"), "1991-5-6", d1License,
        DriverHistory.createNew());
    this.d2 = new Driver(new Name("joe", "smith"), "1995-5-6", d2License,
        DriverHistory.createNew());
  }

  @Test
  public void getName() {
    assertEquals(new Name("john", "smith"), this.d1.getName());
  }

  @Test
  public void getBirthDate() {
    assertEquals(new Date(91, 4, 6), this.d1.getBirthDate());
  }

  @Test
  public void getLicense() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    assertEquals(d1License, this.d1.getLicense());
  }

  @Test
  public void getDriverHistory() {
    assertEquals(DriverHistory.createNew(), this.d1.getDriverHistory());
  }

  @Test
  public void testEqualsSame() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    Driver d1Copy = new Driver(new Name("john", "smith"), "1991-5-6", d1License,
        DriverHistory.createNew());
    assertEquals(this.d1, this.d1);
    assertEquals(this.d1, d1Copy);
  }

  @Test
  public void testEqualsDifferent() throws IllegalDateFormat {
    assertNotEquals(this.d1, this.d2);
    assertNotEquals(this.d1, null);
    assertNotEquals(this.d1, new Name("john", "smith"));
  }

  @Test
  public void testHashCode() {
    assertEquals(this.d1.hashCode(), this.d1.hashCode());
    assertNotEquals(this.d1.hashCode(), this.d2.hashCode());
  }
}