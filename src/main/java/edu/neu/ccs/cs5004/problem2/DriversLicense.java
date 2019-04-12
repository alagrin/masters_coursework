package edu.neu.ccs.cs5004.problem2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Represents a drivers license issued to a single driver.
 */
public class DriversLicense {

  private String idNumber;
  private Name name;
  private String address;
  private Date birthDate;
  private String issuingCountry;
  private String issuingState;
  private Date issueDate;
  private Date expireDate;

  /**
   * Constructs a new drivers license. Note all dates must be in yyy-MM-dd form and represent a
   * valid date. Otherwise an exception will be thrown.
   *
   * @param idNumber the license id number
   * @param name the name of the person holding the license
   * @param address the address of the driver
   * @param birthDate the drivers birthdate
   * @param issuingCountry the country issuing the license. Use three letter codes, ex USA or MEX
   * @param issuingState two letter code of the state issuing the license
   * @param issueDate the date the license was issued
   * @param expireDate the date the license expires
   * @throws IllegalDateFormat If a date is incorrectly formatted
   */
  public DriversLicense(String idNumber, Name name, String address, String birthDate,
      String issuingCountry, String issuingState, String issueDate, String expireDate)
      throws IllegalDateFormat {
    this.idNumber = idNumber;
    this.name = name;
    this.address = address;
    this.issuingCountry = issuingCountry;
    this.issuingState = issuingState;
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //converts strings to date
      this.birthDate = format.parse(birthDate);
      this.issueDate = format.parse(issueDate);
      this.expireDate = format.parse(expireDate);
    } catch (ParseException exception) {
      throw new IllegalDateFormat("please format dates in yyyy-MM-dd form");
    }
  }

  /**
   * Returns the id number of license.
   *
   * @return the id number
   */
  public String getIdNumber() {
    return this.idNumber;
  }

  /**
   * Returns the name object representing the license holder.
   *
   * @return the name object
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Returns the address of the license holder.
   *
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Returns the birthdate Date object.
   *
   * @return the birth date of the license holder
   */
  public Date getBirthDate() {
    return new Date(this.birthDate.getTime());
  }

  /**
   * Returns a three letter code representing the issuing country.
   *
   * @return the issuing country
   */
  public String getIssuingCountry() {
    return this.issuingCountry;
  }

  /**
   * The issuing state, a two letter code.
   *
   * @return the state that issued the license
   */
  public String getIssuingState() {
    return this.issuingState;
  }

  /**
   * the date the license was issued.
   *
   * @return the date the license was issues
   */
  public Date getIssueDate() {
    return new Date(this.issueDate.getTime());
  }

  /**
   * The date the license expires.
   *
   * @return the expiration date
   */
  public Date getExpireDate() {
    return new Date(this.expireDate.getTime());
  }

  /**
   * Returns true if two licenses are equal.
   *
   * @param other license to compare to
   * @return true if licenses are equal
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    DriversLicense that = (DriversLicense) other;
    return Objects.equals(idNumber, that.idNumber)
        && Objects.equals(name, that.name)
        && Objects.equals(address, that.address)
        && Objects.equals(birthDate, that.birthDate)
        && Objects.equals(issuingCountry, that.issuingCountry)
        && Objects.equals(issuingState, that.issuingState)
        && Objects.equals(issueDate, that.issueDate)
        && Objects.equals(expireDate, that.expireDate);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return a numeric representation of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(idNumber, name, address, birthDate, issuingCountry, issuingState, issueDate,
        expireDate);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representing the object.
   */
  @Override
  public String toString() {
    return "DriversLicense{"
        + "idNumber='" + idNumber + '\''
        + ", name=" + name + ", address='" + address + '\''
        + ", birthDate=" + birthDate + ", issuingCountry='" + issuingCountry + '\''
        + ", issuingState='" + issuingState + '\'' + ", issueDate=" + issueDate
        + ", expireDate=" + expireDate + '}';
  }
}
