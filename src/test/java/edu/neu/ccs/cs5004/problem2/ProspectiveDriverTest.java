package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ProspectiveDriverTest {

  private ProspectiveDriver d1;

  @Before
  public void setup() throws Exception {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    VehicleInsurance insur = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2020-5-6");
    this.d1 = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6", d1License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insur, VehicleHistory.createNew());
  }

  @Test
  public void getVehicle() {
    assertEquals(new VehicleInformation("BMW", "X5", 2002, new Name("john", "smith"))
        , d1.getVehicle());
  }

  @Test
  public void getInsurance() throws IllegalDateFormat {
    VehicleInsurance insur = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2020-5-6");
    assertEquals(insur, this.d1.getInsurance());
  }

  @Test
  public void getVehicleHistory() {
    assertEquals(VehicleHistory.createNew(), this.d1.getVehicleHistory());
  }

  @Test
  public void getAsDriver() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    Driver driver = new Driver(new Name("john", "smith"), "1991-5-6", d1License,
        DriverHistory.createNew());
    assertEquals(driver, d1.getAsDriver());
  }

  @Test
  public void equalsSame() throws IllegalDateFormat {
    //create a new copy of the same driver
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    VehicleInsurance insur = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2020-5-6");
    ProspectiveDriver d2 = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6", d1License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insur, VehicleHistory.createNew());
    assertEquals(this.d1, this.d1);
    assertEquals(this.d1, d2);
  }

  @Test
  public void equalsDifferent() throws IllegalDateFormat {
    DriversLicense d2License = new DriversLicense("1234", new Name("joe", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    VehicleInsurance insur = new VehicleInsurance(new Name("joe", "smith"), new ArrayList<>(),
        "2020-5-6");
    ProspectiveDriver d2 = new ProspectiveDriver(new Name("jow", "smith"), "1995-5-6", d2License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2005,
        new Name("john", "smith")), insur, VehicleHistory.createNew());
    assertNotEquals(this.d1, null);
    assertNotEquals(this.d1, VehicleHistory.createNew());
    assertNotEquals(this.d1, d2);
  }

  @Test
  public void testhashCode() throws IllegalDateFormat {
    DriversLicense d2License = new DriversLicense("1234", new Name("joe", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    VehicleInsurance insur = new VehicleInsurance(new Name("joe", "smith"), new ArrayList<>(),
        "2020-5-6");
    ProspectiveDriver d2 = new ProspectiveDriver(new Name("jow", "smith"), "1995-5-6", d2License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2005,
        new Name("john", "smith")), insur, VehicleHistory.createNew());
    assertNotEquals(this.d1.hashCode(), d2.hashCode());
    assertEquals(this.d1.hashCode(), this.d1.hashCode());
  }
}