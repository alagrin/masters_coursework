package edu.neu.ccs.cs5004.problem2;


import java.util.Objects;

/**
 * A prospective driver is the combination of a driver and a specific vehicle to be checked by the
 * registration validation system.
 */

public class ProspectiveDriver extends Driver {


  private VehicleInformation vehicle;
  private VehicleInsurance insurance;
  private VehicleHistory vehicleHistory;

  /**
   * Constructs a new prospective driver.
   *
   * @param name name of the driver
   * @param birthDate birthdate in yyyy-mm-dd format
   * @param license the drivers license
   * @param driverHistory driver history
   * @param vehicle information about the vehicle
   * @param insurance information about the vehicle's insurance
   * @param vehicleHistory information about previous indicants in the vehicle
   * @throws IllegalDateFormat if the date is formatted incorrectly
   */
  public ProspectiveDriver(Name name, String birthDate,
      DriversLicense license, DriverHistory driverHistory,
      VehicleInformation vehicle, VehicleInsurance insurance,
      VehicleHistory vehicleHistory) throws IllegalDateFormat {
    super(name, birthDate, license, driverHistory);
    this.vehicle = vehicle;
    this.insurance = insurance;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Returns the vehicle information.
   *
   * @return Vehicle information object
   */
  public VehicleInformation getVehicle() {
    return this.vehicle;
  }

  /**
   * Returns the insurance information.
   *
   * @return the insurance information
   */
  public VehicleInsurance getInsurance() {
    return this.insurance;
  }

  /**
   * Returns the vehicle history.
   *
   * @return the vehicle history
   */
  public VehicleHistory getVehicleHistory() {
    return this.vehicleHistory;
  }

  /**
   * Returns just the driver without vehicle information. For use after driver is accepted.
   *
   * @return A new driver object,
   */
  public Driver getAsDriver() {
    return new Driver(this.getName(), this.getBirthDate(), this.getLicense(),
        this.getDriverHistory());
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
    if (!super.equals(other)) {
      return false;
    }
    ProspectiveDriver that = (ProspectiveDriver) other;
    return Objects.equals(vehicle, that.vehicle)
        && Objects.equals(insurance, that.insurance)
        && Objects.equals(vehicleHistory, that.vehicleHistory);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return a numeric representation
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), vehicle, insurance, vehicleHistory);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string of the object;
   */
  @Override
  public String toString() {
    return "ProspectiveDriver{"
        + "vehicle=" + vehicle
        + ", insurance=" + insurance
        + ", vehicleHistory=" + vehicleHistory
        + '}';
  }
}
