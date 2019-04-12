package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class RegistrationValidatorTest {

  private ProspectiveDriver validDriver;
  private ProspectiveDriver tooYoungDriver;
  private VehicleInsurance insurance;
  private DriversLicense license;

  private RegistrationValidator validator;

  @Before
  public void setUp() throws Exception {
    this.license = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2020-4-10");
    this.insurance = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2020-5-6");
    this.validDriver = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6", license,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2005,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    this.tooYoungDriver = new ProspectiveDriver(new Name("john", "smith"), "1991-4-1", license,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    this.validator = new RegistrationValidator();
  }

  @Test
  public void addProspectiveDriverCheckAge() {
    assertFalse(validator.addProspectiveDriver(tooYoungDriver));
    assertFalse(validator.getAcceptedDrivers().containsKey(tooYoungDriver.getAsDriver()));
  }

  @Test
  public void addProspectiveDriverCheckLicenseValid() {
    assertTrue(validator.addProspectiveDriver(validDriver));
    assertTrue(validator.getAcceptedDrivers().containsKey(validDriver.getAsDriver()));

  }

  @Test
  public void addProspectiveDriverMultipleTimes() {
    assertTrue(validator.addProspectiveDriver(validDriver));
    assertFalse(validator.addProspectiveDriver(validDriver));
  }

  @Test
  public void addProspectiveDriverCheckAddWorks() {
    assertTrue(validator.addProspectiveDriver(validDriver));
    Map<Driver, Set<VehicleInformation>> drivers = validator.getAcceptedDrivers();
    assertTrue(drivers.containsKey(this.validDriver.getAsDriver()));
    assertTrue(drivers.get(this.validDriver.getAsDriver()).contains(this.validDriver.getVehicle()));
  }

  @Test
  public void addProspectiveDriverCheckLicenseExpired() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "2005-4-10", "2010-4-10"); // expired license
    ProspectiveDriver expired = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        d1License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(expired));
  }

  @Test
  public void addProspectiveDriverCheckLicenseTooNew() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1991-5-6", "USA", "WA", "20019-2-10", "2020-4-10"); // too new license
    ProspectiveDriver tooNew = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        d1License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(tooNew));
  }

  @Test
  public void addProspectiveDriverCheckLicenseBirthdateMismatch() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1995-5-6", "USA", "WA", "2009-2-10", "2020-4-10"); //different birthdate
    ProspectiveDriver mismatch = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        d1License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(mismatch));
  }

  @Test
  public void addProspectiveDriverCheckLicenseNonUSLicense() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1995-5-6", "MEX", "WA", "2009-2-10", "2020-4-10"); //different country
    ProspectiveDriver nonUS = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        d1License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(nonUS));
  }

  @Test
  public void addProspectiveDriverCheckLicenseNameMismatch() throws IllegalDateFormat {
    DriversLicense d1License = new DriversLicense("1234", new Name("john", "smith"), "1234 1st",
        "1995-5-6", "USA", "WA", "2009-2-10", "2020-4-10"); // name mismatch
    ProspectiveDriver mismatch = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        d1License,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(mismatch));
  }

  @Test
  public void addProspectiveDriverCheckLicenseInvalidVehicle() throws IllegalDateFormat {
    ProspectiveDriver oldVehicle = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        license,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 1995,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(oldVehicle));
  }

  @Test
  public void addProspectiveDriverExpiredInsurence() throws IllegalDateFormat {
    this.insurance = new VehicleInsurance(new Name("john", "smith"), new ArrayList<>(),
        "2018-5-6");
    ProspectiveDriver expiredInsur = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        license,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(expiredInsur));
  }

  @Test
  public void addProspectiveDriverNotCoveredByInsurence() throws IllegalDateFormat {
    this.insurance = new VehicleInsurance(new Name("joe", "smith"), new ArrayList<>(),
        "2020-5-6");
    ProspectiveDriver notCovered = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        license,
        DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertFalse(validator.addProspectiveDriver(notCovered));
  }

  @Test
  public void addProspectiveDriverCoveredByInsurenceSecondary() throws IllegalDateFormat {
    List<Name> names = new ArrayList<>();
    names.add(new Name("john", "smith"));
    this.insurance = new VehicleInsurance(new Name("joe", "smith"), names, "2020-5-6");
    ProspectiveDriver secondaryCovered = new ProspectiveDriver(new Name("john", "smith"),
        "1991-5-6",
        license, DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, VehicleHistory.createNew());
    assertTrue(validator.addProspectiveDriver(secondaryCovered));
  }

  @Test
  public void addProspectiveDriverRecentAccident() throws IllegalDateFormat {
    VehicleHistory history = VehicleHistory.createNew();
    history.addAccident(
        new Accident("2019-1-3", new Name("john", "smith"), AccidentType.CRASH_NO_INJURY));
    ProspectiveDriver recentAccident = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        license, DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, history);
    assertFalse(validator.addProspectiveDriver(recentAccident));
  }

  @Test
  public void addProspectiveDriverRecentViolation() throws IllegalDateFormat {
    VehicleHistory history = VehicleHistory.createNew();
    history.addViolation(new MovingViolation("2019-1-3", MovingViolationType.RECKLESS_DRIVING));
    ProspectiveDriver recentViolation = new ProspectiveDriver(new Name("john", "smith"), "1991-5-6",
        license, DriverHistory.createNew(), new VehicleInformation("BMW", "X5", 2002,
        new Name("john", "smith")), insurance, history);
    assertFalse(validator.addProspectiveDriver(recentViolation));
  }
}