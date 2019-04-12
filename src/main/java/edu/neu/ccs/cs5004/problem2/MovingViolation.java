package edu.neu.ccs.cs5004.problem2;


import java.util.Objects;

/**
 * Shared information and data for moving violations.
 */
public class MovingViolation extends AbstractViolation {

  protected MovingViolationType movingViolationType;

  /**
   * Updates fields with given parameters.
   *
   * @param dateOfViolation date the violation occurred
   * @param movingViolationType type of moving violation it is
   * @throws IllegalDateFormat if the date is formatted incorrectly
   */
  public MovingViolation(String dateOfViolation, MovingViolationType movingViolationType)
      throws IllegalDateFormat {
    super(dateOfViolation, ViolationType.MOVING);
    this.movingViolationType = movingViolationType;
  }

  /**
   * Returns the type of moving violation this object is.
   *
   * @return they type of moving violation
   */
  public MovingViolationType getMovingViolationTypeType() {
    return this.movingViolationType;
  }

  /**
   * Returns true if the violation disqualifies the driver from driving for our service.
   *
   * @return true if violation is disqualifying.
   */
  @Override
  public boolean isDisqualifying() {
    switch (this.movingViolationType) {
      case DUI:
        return true;
      case RECKLESS_DRIVING:
        return true;
      case DRIVING_WITHOUT_LICENSE_OR_INSURANCE:
        return true;
      case SPEEDING:
        return true;
      default:
        return false;
    }
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
    if (!super.equals(other)) {
      return false;
    }
    MovingViolation violation = (MovingViolation) other;
    return movingViolationType == violation.movingViolationType;
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return a numeric repreesntation
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), movingViolationType);
  }

  /**
   * Returns a string representation of the object.
   * @return a string of the object.
   */
  @Override
  public String toString() {
    return "MovingViolation{"
        + "movingViolationType=" + movingViolationType
        + ", dateOfViolation=" + dateOfViolation
        + ", violationType=" + violationType
        + '}';
  }
}
