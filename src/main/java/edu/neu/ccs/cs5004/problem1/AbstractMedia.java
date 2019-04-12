package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * The general representation of a movie or tv show.
 */
public abstract class AbstractMedia implements Comparable<AbstractMedia> {

  private String alias;
  private String title;
  private Integer releaseYear;
  private List<Director> directors;
  private List<Actor> actors;
  private Integer streamCount;

  /**
   * The constructor for a movie/tv show.
   *
   * @param alias a unique string representation of the media
   * @param title title of the media
   * @param releaseYear release year of the media
   * @param directors a list of directors involved
   * @param actors a list of actors involved
   * @throws InvalidYearException in case the year entered is not within range.
   */
  public AbstractMedia(String alias, String title, Integer releaseYear,
      List<Director> directors, List<Actor> actors) throws InvalidYearException {
    this.alias = alias;
    this.title = title;
    this.releaseYear = releaseYear;
    this.directors = directors;
    this.actors = actors;
    this.streamCount = 0;
    if (this.releaseYear < 1000 || this.releaseYear > 9999) {
      throw new InvalidYearException("Release year must be 4 digits");
    }
  }

  /**
   * Returns the media alias.
   *
   * @return the media alias
   */
  String getAlias() {
    return this.alias;
  }

  /**
   * Returns media title.
   *
   * @return the title of the movie/series
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns the release year.
   *
   * @return the year media was released
   */
  public Integer getReleaseYear() {
    return this.releaseYear;
  }

  /**
   * Returns a list of directors involved in the filming.
   *
   * @return the directors involved
   */
  public List<Director> getDirectors() {
    return this.directors;
  }

  /**
   * Returns a list of actors in the media.
   *
   * @return the actors involved
   */
  public List<Actor> getActors() {
    return this.actors;
  }


  /**
   * Returns the stream count of a particular media.
   *
   * @return the number of times streamed
   */
  public Integer getStreamCount() {
    return this.streamCount;
  }

  /**
   * Adds to stream count when called by MediaLibrary.
   */
  public void addToStreamCount() {
    this.streamCount++;
  }


  /**
   * Checks if two media are the same.
   *
   * @param object the object to compare to
   * @return if the two forms of abstract media objects are the same
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof AbstractMedia)) {
      return false;
    }

    AbstractMedia media = (AbstractMedia) object;

    if (!getAlias().equals(media.getAlias())) {
      return false;
    }
    if (!getTitle().equals(media.getTitle())) {
      return false;
    }
    if (!getReleaseYear().equals(media.getReleaseYear())) {
      return false;
    }
    if (!getDirectors().equals(media.getDirectors())) {
      return false;
    }
    if (!getActors().equals(media.getActors())) {
      return false;
    }
    return getStreamCount().equals(media.getStreamCount());

  }

  /**
   * Returns the number rep. of an object.
   *
   * @return the number representation of object
   */
  @Override
  public int hashCode() {
    int result = getAlias().hashCode();
    result = 31 * result + getTitle().hashCode();
    result = 31 * result + getReleaseYear().hashCode();
    result = 31 * result + getDirectors().hashCode();
    result = 31 * result + getActors().hashCode();
    result = 31 * result + getStreamCount().hashCode();
    return result;
  }

  /**
   * Provides a string representation of the media.
   *
   * @return a string showing the media information
   */
  @Override
  public String toString() {
    return super.toString();
  }

  /** Helper to compare release year values to sort media.
   * @param media media to compare
   * @return a value that helps set order of media list
   */
  @Override
  public int compareTo(AbstractMedia media) {
    return this.getReleaseYear().compareTo(media.getReleaseYear());
  }
}
