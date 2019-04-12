package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * Represents a tv series in the library.
 */
public class TvShow extends AbstractMedia {


  public TvShow(String alias, String title, Integer releaseYear,
      List<Director> directors, List<Actor> actors) throws InvalidYearException {
    super(alias, title, releaseYear, directors, actors);
  }
}
