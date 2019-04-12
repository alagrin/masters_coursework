package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;

/**
 * Represents a person's name.
 */

public class Name {

  private String first;
  private String last;

  /**
   * Constructs a new name.
   *
   * @param first first name
   * @param last last name
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Returns the first name.
   *
   * @return the first name
   */
  public String getFirst() {
    return this.first;
  }

  /**
   * Returns the last name.
   *
   * @return the last name
   */
  public String getLast() {
    return this.last;
  }

  /**
   * Returns true if two names are equal.
   *
   * @param other the object to compare
   * @return true if two names are equal
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Name name = (Name) other;
    return first.equals(name.first) && last.equals(name.last);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return a numeric representation of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return "Name{"
        + "first='" + first + '\''
        + ", last='" + last + '\''
        + '}';
  }
}
