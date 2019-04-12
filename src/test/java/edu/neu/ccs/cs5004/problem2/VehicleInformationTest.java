package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class VehicleInformationTest {

  private VehicleInformation info;

  @Before
  public void setup() {
    this.info = new VehicleInformation("BMW", "X5", 2005, new Name("john", "smith"));
  }

  @Test
  public void getMake() {
    assertEquals("BMW", info.getMake());
  }

  @Test
  public void getModel() {
    assertEquals("X5", info.getModel());
  }

  @Test
  public void getYear() {
    assertEquals((Integer) 2005, info.getYear());
  }

  @Test
  public void getOfficialOwner() {
    assertEquals(new Name("john", "smith"), this.info.getOfficialOwner());
  }

  @Test
  public void equalsSame() {
    assertEquals(this.info, this.info);
    assertEquals(new VehicleInformation("BMW", "X5", 2005, new Name("john", "smith")), this.info);
  }

  @Test
  public void equalsDifferent() {
    assertNotEquals(null, this.info);
    assertNotEquals(new VehicleInformation("Chevy", "camaro", 2005, new Name("john", "smith")),
        this.info);
  }

  @Test
  public void testHashCodeSame() {
    assertEquals((new VehicleInformation("BMW", "X5", 2005, new Name("john", "smith"))).hashCode(),
        this.info.hashCode());
  }

  @Test
  public void testHashCodeDifferent() {
    assertNotEquals(
        (new VehicleInformation("Chevy", "si", 2005, new Name("john", "smith"))).hashCode()
        , this.info.hashCode());
  }
}