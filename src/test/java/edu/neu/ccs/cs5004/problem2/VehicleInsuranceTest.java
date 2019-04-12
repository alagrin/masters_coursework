package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleInsuranceTest {

  private VehicleInsurance insur;

  @Before
  public void setUp() throws Exception {
    this.insur = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(), "2020-05-06");
    this.insur.addCoveredDriver(new Name("joe", "smith"));
  }

  @Test
  public void getName() {
    assertEquals(this.insur.getName(), new Name("john", "smith"));
  }

  @Test
  public void getOthersCoveredDrivers() {
    List<Name> otherDrivers = this.insur.getOthersCoveredDrivers();
    assertTrue(otherDrivers.contains(new Name("joe", "smith")));
  }

  @Test
  public void getExpireDate() {
    Date date = this.insur.getExpireDate();
    Date testDate = new Date(120, 4, 6);
    assertEquals(date, testDate);
  }

  @Test
  public void addCoveredDriver() {
    this.insur.addCoveredDriver(new Name("jane", "smith"));
    List<Name> otherDrivers = this.insur.getOthersCoveredDrivers();
    assertTrue(otherDrivers.contains(new Name("jane", "smith")));
  }

  @Test
  public void testequalsSame() throws Exception {
    assertEquals(this.insur, this.insur);
    VehicleInsurance insur2 = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2020-05-06");
    insur2.addCoveredDriver(new Name("joe", "smith"));
    assertEquals(this.insur, insur2);
  }

  @Test
  public void testequalsDifferentDate() throws Exception {
    VehicleInsurance insur2 = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2022-05-06");
    insur2.addCoveredDriver(new Name("joe", "smith"));
    assertNotEquals(this.insur, insur2);
  }

  @Test
  public void testequalsDifferentDriver() throws Exception {
    VehicleInsurance insur2 = new VehicleInsurance(new Name("albert", "smith"), new ArrayList<>(),
        "2020-05-06");
    insur2.addCoveredDriver(new Name("joe", "smith"));
    assertNotEquals(this.insur, insur2);
  }

  @Test
  public void testequalsDifferentCoveredDriver() throws Exception {
    VehicleInsurance insur2 = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2020-05-06");
    insur2.addCoveredDriver(new Name("jane", "smith"));
    assertNotEquals(this.insur, insur2);
  }

  @Test
  public void testhashCode() throws Exception {
    assertEquals(this.insur.hashCode(), this.insur.hashCode());
    assertNotEquals(this.insur.hashCode(),
        new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(), "2020-05-06")
            .hashCode());
  }
}