package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;

/**
 * Contains information about a single Vehicle.
 */
public class VehicleInformation {

  private String make;
  private String model;
  private Integer year;
  private Name officialOwner;

  /**
   * Constructs a new Vehicle.
   *
   * @param make the make of the vehicle
   * @param model the model of the vehicle
   * @param year the year of the vehicle
   * @param officialOwner the Name of the registered owner
   */
  public VehicleInformation(String make, String model, Integer year,
      Name officialOwner) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.officialOwner = officialOwner;
  }

  /**
   * Returns the make of the Vehicle.
   *
   * @return the make of the vehicle
   */
  public String getMake() {
    return this.make;
  }

  /**
   * Returns the model of the vehicle.
   *
   * @return the model of the vehicle
   */
  public String getModel() {
    return this.model;
  }

  /**
   * Returns the year of the vehicle.
   *
   * @return the year of the vehicle
   */
  public Integer getYear() {
    return this.year;
  }

  /**
   * Returns the Name of the official owner of the vehicle.
   *
   * @return the name of the owner
   */
  public Name getOfficialOwner() {
    return this.officialOwner;
  }

  /**
   * Returns true if other equals this.
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
    VehicleInformation that = (VehicleInformation) other;
    return Objects.equals(make, that.make)
        && Objects.equals(model, that.model)
        && Objects.equals(year, that.year)
        && Objects.equals(officialOwner, that.officialOwner);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return a numeric representation
   */
  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, officialOwner);
  }

  @Override
  public String toString() {
    return "VehicleInformation{"
        + "make='" + make + '\''
        + ", model='" + model + '\''
        + ", year=" + year
        + ", officialOwner=" + officialOwner
        + '}';
  }
}
