package edu.neu.ccs.cs5004.problem2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents information about a vehicle's insurance.
 */
public class VehicleInsurance {

  private Name name;
  private List<Name> otherCoveredDrivers;
  private Date expireDate;

  /**
   * Constructs a new VehicleInsurance instance.
   *
   * @param name name of official owner
   * @param othersCoveredDrivers names of other covered drivers
   * @param expireDate expiration date
   */
  public VehicleInsurance(Name name,
      List<Name> othersCoveredDrivers, String expireDate) throws IllegalDateFormat {
    this.name = name;
    this.otherCoveredDrivers = othersCoveredDrivers;
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //converts strings to date
      this.expireDate = format.parse(expireDate);
    } catch (ParseException exception) {
      throw new IllegalDateFormat("please format dates in yyyy-MM-dd form");
    }
  }

  /**
   * Returns the name of the official owner.
   *
   * @return the name of the owner
   */
  public Name getName() {
    return this.name;
  }

  /**
   * return the names of other covered drivers.
   *
   * @return the names of other covered drivers
   */
  public List<Name> getOthersCoveredDrivers() {
    return this.otherCoveredDrivers;
  }

  /**
   * return the date the insurance expires.
   *
   * @return the expiration date
   */
  public Date getExpireDate() {
    return new Date(this.expireDate.getTime());
  }

  /**
   * adds a new covered driver to the insurance.
   *
   * @param newDriver new driver to add
   */
  public void addCoveredDriver(Name newDriver) {
    this.otherCoveredDrivers.add(newDriver);
  }

  /**
   * Determines if two objects are equal.
   *
   * @param other the object to compare
   * @return true if objects are equal
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    VehicleInsurance that = (VehicleInsurance) other;
    return Objects.equals(name, that.name)
        && Objects.equals(otherCoveredDrivers, that.otherCoveredDrivers)
        && Objects.equals(expireDate, that.expireDate);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, otherCoveredDrivers, expireDate);
  }

  @Override
  public String toString() {
    return "VehicleInsurance{"
        + "name=" + name
        + ", otherCoveredDrivers=" + otherCoveredDrivers
        + ", expireDate=" + expireDate
        + '}';
  }
}
