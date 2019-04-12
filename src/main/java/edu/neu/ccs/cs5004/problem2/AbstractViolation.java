package edu.neu.ccs.cs5004.problem2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Shared data and behavior for driving violations.
 */
public abstract class AbstractViolation {

  protected Date dateOfViolation;
  protected ViolationType violationType;

  /**
   * Updates fields.
   *
   * @param dateOfViolation the date the violation occured
   * @param violationType the type of violation it was
   * @throws IllegalDateFormat if the date is formatted incorrectly
   */
  public AbstractViolation(String dateOfViolation,
      ViolationType violationType) throws IllegalDateFormat {
    this.violationType = violationType;
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //converts strings to date
      this.dateOfViolation = format.parse(dateOfViolation);
    } catch (ParseException exception) {
      throw new IllegalDateFormat("please format dates in yyyy-MM-dd form");
    }
  }

  /**
   * Returns the date of the violation.
   *
   * @return the date of the violation
   */
  public Date getDateOfViolation() {
    return new Date(this.dateOfViolation.getTime());
  }

  /**
   * Returns true if the violation disqualifies the driver from driving for our service.
   *
   * @return true if violation is disqualifying.
   */
  public abstract boolean isDisqualifying();

  /**
   * Returns the type of the violation.
   *
   * @return the type of the violation
   */
  public ViolationType getViolationType() {
    return this.violationType;
  }

  /**
   * Returns true if that equals this.
   *
   * @param other the object to compare
   * @return whether the objects are equal
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    AbstractViolation that = (AbstractViolation) other;
    return Objects.equals(dateOfViolation, that.dateOfViolation)
        && violationType == that.violationType;
  }

  /**
   * Gives a numeric representation of the object.
   *
   * @return a numeric representation.
   */
  @Override
  public int hashCode() {
    return Objects.hash(dateOfViolation, violationType);
  }
}
