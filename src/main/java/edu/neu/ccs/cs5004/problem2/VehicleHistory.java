package edu.neu.ccs.cs5004.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains information about a vehicle's history including all traffic violations and all
 * accidents.
 */
public class VehicleHistory {

  private List<Accident> accidents;
  private List<AbstractViolation> violations;

  /**
   * Creates a new Vehicle History with given lists.
   *
   * @param accidents a list of all accidents
   * @param violations a list of all violations
   */
  public VehicleHistory(List<Accident> accidents,
      List<AbstractViolation> violations) {
    this.accidents = accidents;
    this.violations = violations;
  }

  /**
   * Creates a new empty history.
   *
   * @return empty Vehicle History
   */
  public static VehicleHistory createNew() {
    return new VehicleHistory(new ArrayList<>(), new ArrayList<>());
  }

  /**
   * returns a list of all accidents.
   *
   * @return all the vehicle's accidents
   */
  public List<Accident> getAccidents() {
    return this.accidents;
  }

  /**
   * Returns a list of all violations committed in the car.
   *
   * @return a list of all violations
   */
  public List<AbstractViolation> getViolations() {
    return this.violations;
  }

  /**
   * Adds an accident to the history.
   *
   * @param toAdd the accident to add
   */
  public void addAccident(Accident toAdd) {
    this.accidents.add(toAdd);
  }

  /**
   * Adds a violation to the history.
   *
   * @param toAdd the violation to add
   */
  public void addViolation(AbstractViolation toAdd) {
    this.violations.add(toAdd);
  }

  /**
   * Returns true if this equals other.
   *
   * @param other the object to compare.
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
    VehicleHistory that = (VehicleHistory) other;
    return Objects.equals(accidents, that.accidents)
        && Objects.equals(violations, that.violations);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(accidents, violations);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "VehicleHistory{"
        + "accidents=" + accidents
        + ", violations=" + violations
        + '}';
  }
}
