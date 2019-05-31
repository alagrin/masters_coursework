package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Represents full name of a customer.
 */
public class Name {
  private String first;
  private String last;

  /**
   * Full name representation of customer.
   * @param first first name
   * @param last last name
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Gets first name.
   * @return first name
   */
  public String getFirst() {
    return first;
  }

  /**
   * Allows to set/change the customer name.
   * @param first first name to set as
   */
  public void setFirst(String first) {
    this.first = first;
  }

  /**
   * Gets last name.
   * @return the last name
   */
  public String getLast() {
    return last;
  }

  /**
   * Sets the updated last name.
   * @param last the last name
   */
  public void setLast(String last) {
    this.last = last;
  }

  @Override
  public String toString() {
    return "Name{"
        + "first='" + first + '\''
        + ", last='" + last + '\'' + '}';
  }
}
