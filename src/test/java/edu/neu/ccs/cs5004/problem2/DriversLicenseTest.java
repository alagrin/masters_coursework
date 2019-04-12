package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class DriversLicenseTest {

  private DriversLicense license;
  private SimpleDateFormat format;

  @Before
  public void setUp() throws Exception {
    this.license = new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1991-04-12",
        "USA", "WA", "2005-11-31", "2019-06-12");
    this.format = new SimpleDateFormat("yyyy-MM-dd");
  }


  @Test
  public void testDateFormatException() {
    try {
      this.license = new DriversLicense("1234", new Name("john", "smith"), "1234 99st",
          "May 5th 2002",
          "USA", "WA", "2005-11-31", "2019-06-12");
      fail("expceted exception");
    } catch (IllegalDateFormat e) {
    }
  }

  @Test
  public void getIdNumber() {
    assertEquals("1234", license.getIdNumber());
  }

  @Test
  public void getName() {
    assertEquals(new Name("john", "smith"), license.getName());
  }

  @Test
  public void getAddress() {
    assertEquals("1234 99st", license.getAddress());
  }

  @Test
  public void getBirthDate() throws ParseException {
    Date testDate = format.parse("1991-04-12");
    assertEquals(testDate, this.license.getBirthDate());
  }

  @Test
  public void getIssuingCountry() {
    assertEquals("USA", this.license.getIssuingCountry());
  }

  @Test
  public void getIssuingState() {
    assertEquals("WA", this.license.getIssuingState());
  }

  @Test
  public void getIssueDate() throws ParseException {
    Date testDate = format.parse("2005-11-31");
    assertEquals(testDate, this.license.getIssueDate());
  }

  @Test
  public void getExpireDate() throws ParseException {
    Date testDate = format.parse("2019-06-12");
    assertEquals(testDate, this.license.getExpireDate());
  }

  @Test
  public void equalsSame() throws IllegalDateFormat {
    assertEquals(this.license, this.license);
    assertEquals(new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1991-04-12",
        "USA", "WA", "2005-11-31", "2019-06-12"), this.license);
  }

  @Test
  public void equalsDifferentID() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("4321", new Name("and", "smith"), "4321 1st", "1981-04-12",
        "MEX", "OR", "2001-11-31", "2020-05-12"), this.license);
  }

  @Test
  public void equalsDifferentNAme() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("1234", new Name("and", "smith"), "4321 1st", "1981-04-12",
        "MEX", "OR", "2001-11-31", "2020-05-12"), this.license);
  }

  @Test
  public void equalsDifferentAddress() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("1234", new Name("john", "smith"), "4321 1st", "1981-04-12",
        "MEX", "OR", "2001-11-31", "2020-05-12"), this.license);
  }

  @Test
  public void equalsDifferentBirthDate() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1981-04-12",
        "MEX", "OR", "2001-11-31", "2020-05-12"), this.license);
  }

  @Test
  public void equalsDifferentCountry() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1991-04-12",
        "MEX", "OR", "2001-11-31", "2020-05-12"), this.license);
  }

  @Test
  public void equalsDifferentState() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1991-04-12",
        "USA", "OR", "2001-11-31", "2020-05-12"), this.license);
  }

  @Test
  public void equalsDifferentIssue() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1991-04-12",
        "USA", "WA", "2001-11-31", "2020-05-12"), this.license);
  }

  @Test
  public void equalsDifferentExpire() throws IllegalDateFormat {
    assertNotEquals(new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1991-04-12",
        "USA", "WA", "2005-11-31", "2020-5-12"), this.license);
  }

  @Test
  public void testHashCode() throws IllegalDateFormat {
    assertEquals((new DriversLicense("1234", new Name("john", "smith"), "1234 99st", "1991-04-12",
        "USA", "WA", "2005-11-31", "2019-06-12")).hashCode(), this.license.hashCode());
  }
}