package edu.neu.ccs.cs5004.problem2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Represents a driver with no vehicle information.
 */
public class Driver {

  private Name name;
  private Date birthDate;
  private DriversLicense license;
  private DriverHistory driverHistory;

  /**
   * Constructs a new driver.
   *
   * @param name the drivers name
   * @param birthDate birthdate as a string in yyyy-mm-dd format
   * @param license the driver's license information
   * @param driverHistory the driver's history
   * @throws IllegalDateFormat if the date is formatted incorrectly
   */
  public Driver(Name name, String birthDate, DriversLicense license,
      DriverHistory driverHistory) throws IllegalDateFormat {
    this.name = name;
    this.license = license;
    this.driverHistory = driverHistory;
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //converts strings to date
      this.birthDate = format.parse(birthDate);
    } catch (ParseException exception) {
      throw new IllegalDateFormat("please format dates in yyyy-MM-dd form");
    }
  }

  /**
   * Creates a new Driver.
   *
   * @param name the drivers name.
   * @param birthDate the driver's birthdate as a Date object.
   * @param license the license information
   * @param driverHistory the driver's history
   */
  public Driver(Name name, Date birthDate, DriversLicense license,
      DriverHistory driverHistory) {
    this.name = name;
    this.license = license;
    this.driverHistory = driverHistory;
    this.birthDate = new Date(birthDate.getTime());
  }

  /**
   * Returns the driver's name.
   *
   * @return Name object
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Returns the driver's birthdate.
   *
   * @return the birth date
   */
  public Date getBirthDate() {
    return new Date(this.birthDate.getTime());
  }

  /**
   * Returns the driver's license information.
   *
   * @return the drivers license.
   */
  public DriversLicense getLicense() {
    return this.license;
  }

  /**
   * Returns the driver's history.
   *
   * @return the driver's history
   */
  public DriverHistory getDriverHistory() {
    return this.driverHistory;
  }

  /**
   * Returns true if this equals other.
   *
   * @param other object to compare
   * @return true if objects are equal.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Driver driver = (Driver) other;
    return Objects.equals(name, driver.name)
        && Objects.equals(birthDate, driver.birthDate)
        && Objects.equals(license, driver.license)
        && Objects.equals(driverHistory, driver.driverHistory);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return the numeric representation
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, birthDate, license, driverHistory);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "Driver{"
        + "name="
        + name + ", birthDate=" + birthDate
        + ", license=" + license
        + ", driverHistory=" + driverHistory
        + "}";
  }
}
