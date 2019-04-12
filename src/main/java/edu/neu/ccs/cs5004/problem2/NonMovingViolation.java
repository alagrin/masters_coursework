package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;

/**
 * Represents a non-moving violation.
 */

public class NonMovingViolation extends AbstractViolation {

  private NonMovingViolationType nonMovingViolationType;

  /**
   * Constructs a new non moving violation.
   *
   * @param dateOfViolation date the violation occurred in YYYY-MM-DD format
   * @param nonMovingViolationType the type of non moving violation it is
   * @throws IllegalDateFormat if the date is incorrectly formatted
   */
  public NonMovingViolation(String dateOfViolation, NonMovingViolationType nonMovingViolationType)
      throws IllegalDateFormat {
    super(dateOfViolation, ViolationType.NON_MOVING);
    this.nonMovingViolationType = nonMovingViolationType;
  }

  /**
   * Returns true if the violation disqualifies the driver.
   *
   * @return true if disqualifying
   */
  @Override
  public boolean isDisqualifying() {
    return false;
  }

  /**
   * Returns the type of non moving violation violation that this is.
   *
   * @return the type of non moving violation it is
   */
  public NonMovingViolationType getNonMovingViolationType() {
    return this.nonMovingViolationType;
  }

  /**
   * Returns true if this equals other.
   *
   * @param other the object to compare
   * @return true if equal
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
    NonMovingViolation that = (NonMovingViolation) other;
    return nonMovingViolationType == that.nonMovingViolationType;
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), nonMovingViolationType);
  }

  /**
   * Retruns a String representation of the object.
   * @return a string of the object.
   */
  @Override
  public String toString() {
    return "NonMovingViolation{"
        + "nonMovingViolationType=" + nonMovingViolationType
        + ", dateOfViolation=" + dateOfViolation
        + ", violationType=" + violationType
        + '}';
  }
}
