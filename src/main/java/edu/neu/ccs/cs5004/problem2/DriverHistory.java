package edu.neu.ccs.cs5004.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An object that represents a driver's history.
 */
public class DriverHistory {

  private List<MovingViolation> movingViolations;
  private List<NonMovingViolation> nonMovingViolations;

  /**
   * Creates a new DriverHistory.
   *
   * @param movingViolations a list of moving violations.
   * @param nonMovingViolations a list of non moving violations.
   */
  public DriverHistory(
      List<MovingViolation> movingViolations,
      List<NonMovingViolation> nonMovingViolations) {
    this.movingViolations = movingViolations;
    this.nonMovingViolations = nonMovingViolations;
  }

  /**
   * Creates a new DriverHistory with no incidents.
   */
  public static DriverHistory createNew() {
    return new DriverHistory(new ArrayList<>(), new ArrayList<>());
  }

  /**
   * Returns a list of all moving violations.
   *
   * @return a list of all moving violations.
   */
  public List<MovingViolation> getMovingViolations() {
    return this.movingViolations;
  }

  /**
   * Returns a list of all non-moving violations.
   *
   * @return a list of all non-moving violations.
   */
  public List<NonMovingViolation> getNonMovingViolations() {
    return this.nonMovingViolations;
  }

  /**
   * Adds a movingViolation to the history.
   *
   * @param toAdd moving violation to add.
   */
  public void add(MovingViolation toAdd) {
    this.movingViolations.add(toAdd);
  }

  /**
   * Adds a non moving violation to the history.
   */
  public void add(NonMovingViolation toAdd) {
    this.nonMovingViolations.add(toAdd);
  }

  /**
   * Returns true if the list contains a violation such as DUI, Reckless driving etc that
   * disqualifies the driver from driving with our service.
   *
   * @return true if there is a disqualifying violation
   */
  public boolean containsDisqualifyingViolation() {
    boolean result = true;
    for (MovingViolation violation : movingViolations) {
      result = result && violation.isDisqualifying();
    }
    return result;
  }

  /**
   * Returns true if this equals other.
   *
   * @param other object to compare.
   * @return true if this equals other.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    DriverHistory that = (DriverHistory) other;
    return Objects.equals(movingViolations, that.movingViolations)
        && Objects.equals(nonMovingViolations, that.nonMovingViolations);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return a numeric representation of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(movingViolations, nonMovingViolations);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object
   */
  @Override
  public String toString() {
    return "DriverHistory{"
        + "movingViolations=" + movingViolations
        + ", nonMovingViolations=" + nonMovingViolations
        + '}';
  }
}
