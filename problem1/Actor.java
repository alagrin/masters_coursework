package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem2.Name;

import java.util.Objects;

/**
 * Representation of actor in film/tv show.
 */
public class Actor {

  private Name name;

  /**
   * An instance of an actor.
   *
   * @param name first name
   */
  public Actor(Name name) {
    this.name = name;
  }

  /**
   * Gets the actor name.
   *
   * @return the actor's name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Checks if two actors are the same actor.
   *
   * @param other the actor to compare with
   * @return true if the same actor, false if not
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Actor actor = (Actor) other;
    return getName().equals(actor.getName());
  }

  /**
   * Gets the actor object hashcode.
   *
   * @return the actor hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  /**
   * Generates a string rep of the actor.
   *
   * @return a string describing the actor
   */
  @Override
  public String toString() {
    return "Actor: " + name.getFirst() + " " + name.getLast() + "";
  }
}
