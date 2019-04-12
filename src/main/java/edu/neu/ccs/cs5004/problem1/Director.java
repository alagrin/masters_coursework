package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem2.Name;

import java.util.Objects;

/**
 * Representation of a director of film/tv show.
 */
public class Director {

  private Name name;

  /**
   * Instance of a director - name.
   *
   * @param name the director's name
   */
  public Director(Name name) {
    this.name = name;
  }

  /**
   * Gets director first name.
   *
   * @return the first name
   */
  public Name getName() {
    return this.name;
  }

  /** Compares the two directors.
   * @param other the other director to compare
   * @return true if same director/info, false if not
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Director director = (Director) other;
    return getName().equals(director.getName());
  }

  /** Generates hashcode for director.
   * @return hashcode for the director
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  /** Generates a string representation of director.
   * @return string representation of a director
   */
  @Override
  public String toString() {
    return "Director: " + name.getFirst() + " " + name.getLast() + "";
  }
}
