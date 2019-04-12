package edu.neu.ccs.cs5004.problem2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Accident {

  private Date date;
  private Name atFaultDriver;
  private AccidentType accidentType;

  /**
   * Creates a new Accident.
   * @param date the date the accident occurred
   * @param atFaultDriver the Name of the at fault driver
   * @param accidentType the type of accident it was
   * @throws IllegalDateFormat if the date in not in yyyy-mm-dd format;
   */
  public Accident(String date, Name atFaultDriver, AccidentType accidentType)
      throws IllegalDateFormat {
    this.atFaultDriver = atFaultDriver;
    this.accidentType = accidentType;
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //converts strings to date
      this.date = format.parse(date);
    } catch (ParseException exception) {
      throw new IllegalDateFormat("please format dates in yyyy-MM-dd form");
    }
  }

  /**
   * returns the date of the accident.
   * @return the date of the accident.
   */
  public Date getDate() {
    return new Date(this.date.getTime());
  }

  /**
   * Returns the Name of the at fault driver.
   * @return the Name of at fault driver
   */
  public Name getAtFaultDriver() {
    return atFaultDriver;
  }

  /**
   * Returns the accident type.
   * @return the type of accident
   */
  public AccidentType getAccidentType() {
    return accidentType;
  }

  /**
   * Returns true if this equals other.
   * @param other object to compare
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
    Accident accident = (Accident) other;
    return Objects.equals(date, accident.date)
        && Objects.equals(atFaultDriver, accident.atFaultDriver)
        && accidentType == accident.accidentType;
  }

  /**
   * Returns a integer representation of the object.
   * @return a integer representation of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(date, atFaultDriver, accidentType);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Accident{"
        + "date=" + date
        + ", atFaultDriver=" + atFaultDriver
        + ", accidentType=" + accidentType
        + '}';
  }
}
