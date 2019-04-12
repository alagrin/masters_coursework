package edu.neu.ccs.cs5004.problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The media library handling lists of movies and tv shows.
 */
public class MediaLibrary implements IMediaLibrary {

  private List<Movie> movies;
  private List<TvShow> tvShows;
  private static final Integer INTEGER_MIN = -1;

  /**
   * The media library instance.
   *
   * @param movies A list of movies stored
   * @param tvShows A list of tv shows stored
   */
  public MediaLibrary(List<Movie> movies,
      List<TvShow> tvShows) {
    this.movies = movies;
    this.tvShows = tvShows;

    this.movies = new ArrayList<>();
    this.tvShows = new ArrayList<>();
  }

  /**
   * Gets all the movies and tv shows directed by a specific director.
   *
   * @param director the director to find
   * @return a list of movies and tv shows he/she was involved in
   */

  public List<AbstractMedia> getAllMediaByDirector(Director director) {
    try {
      List<AbstractMedia> mediaList = new ArrayList<>();

      for (AbstractMedia item :
          this.movies) {
        if (item.getDirectors().contains(director)) {
          mediaList.add(item);
        }
      }
      Collections.sort(mediaList);
      return mediaList;
    } catch (Exception e) {
      System.out.println("Couldn't get media for this director");
      return Collections.emptyList();
    }
  }

  /**
   * Adds a new movie or tv show to the library.
   *
   * @param media the media to add
   * @throws MediaAlreadyExistsException in case the movie/tv show is already stored
   */
  @Override
  public void addNewMedia(AbstractMedia media, List<Actor> actors, List<Director> directors)
      throws MediaAlreadyExistsException {

    if (isaMovie(media)) {
      for (AbstractMedia item : this.movies) {
        doesExist(media, item, "movie already exists");
      }
      this.movies.add((Movie) media);
    }

    if (isATvShow(media)) {
      for (AbstractMedia item : this.tvShows) {
        doesExist(media, item, "tv show already exists");
      }
      this.tvShows.add((TvShow) media);
    }
  }

  /**
   * Checks if media is a tv show.
   *
   * @param media the media to check
   * @return true if a tv show, false if not
   */
  private boolean isATvShow(AbstractMedia media) {
    return media.getClass() == TvShow.class;
  }

  /**
   * Helper methods to check if item by such alias exists.
   *
   * @param media the media to check
   * @param item the item in the library
   * @param string appropriate error message
   */
  private void doesExist(AbstractMedia media, AbstractMedia item, String string) {
    if (item.getAlias().equals(media.getAlias())) {
      throw new MediaAlreadyExistsException(string);
    }
  }

  /**
   * Checks the number of stream requests for a particular item.
   *
   * @param alias The alias of the movie/tv show to look up
   * @return a number of stream requests
   */
  @Override
  public Integer trackStreamRequests(String alias) {
    return this.findMediaByAlias(alias).getStreamCount();
  }

  /**
   * When called, adds to the media item's stream count.
   *
   * @param alias the alias of the item to look up
   */
  @Override
  public void addToStreamRequests(String alias) {
    try {
      AbstractMedia itemToCheck = this.findMediaByAlias(alias);

      if (isaMovie(itemToCheck)) {
        for (AbstractMedia item :
            this.movies) {
          checkInLibrary(alias, item);
        }
      }

      if (isATvShow(itemToCheck)) {
        for (AbstractMedia item :
            this.getTvShows()) {
          checkInLibrary(alias, item);
        }
      }
    } catch (ItemNotFoundException e) {
      System.out.println("Could not add to stream count");
    }
  }

  /**
   * Helper, checks for same item and then adds to stream count.
   *
   * @param alias alias to check
   * @param item the media item to compare to
   */
  private void checkInLibrary(String alias, AbstractMedia item) {
    if (item.getAlias().equals(alias)) {
      item.addToStreamCount();
    }
  }

  /**
   * Returns a boolean to check if item is a movie.
   *
   * @param itemToCheck the media item to check for type movie
   * @return true if it's a movie, false if not
   */
  private boolean isaMovie(AbstractMedia itemToCheck) {
    return itemToCheck.getClass() == Movie.class;
  }

  /**
   * Helps find the specific movie/tv show - helper function.
   *
   * @param alias the alias to look up
   * @return the media item to act on
   * @throws ItemNotFoundException in case the item is not in either list
   */
  public AbstractMedia findMediaByAlias(String alias) throws ItemNotFoundException {
    for (AbstractMedia item :
        this.movies) {
      if (item.getAlias().equals(alias)) {
        return item;
      }
    }
    for (AbstractMedia item :
        this.tvShows) {
      if (item.getAlias().equals(alias)) {
        return item;
      }
    }
    throw new ItemNotFoundException("Item not found");
  }

  /**
   * Gets the most streamed media item.
   *
   * @return the media object with most streams
   */
  @Override
  public AbstractMedia getMostStreamed() {
    Integer max = INTEGER_MIN; //so that if no views, can return that item
    AbstractMedia mostViewed = null;

    for (AbstractMedia item :
        this.movies) {
      if (item.getStreamCount() > max) {
        max = item.getStreamCount();
        mostViewed = item;
      }
    }

    for (AbstractMedia item :
        this.tvShows) {
      if (item.getStreamCount() > max) {
        max = item.getStreamCount();
        mostViewed = item;
      }
    }
    return mostViewed;
  }


  /**
   * Returns a list of movies.
   *
   * @return a list of movies in the library
   */
  public List<Movie> getMovies() {
    return this.movies;
  }

  /**
   * Returns a list of tv shows.
   *
   * @return the list of shows
   */
  public List<TvShow> getTvShows() {
    return this.tvShows;
  }


  /**
   * Compares two libraries to see if they are the same.
   *
   * @param object the other library to compare with
   * @return true if the libraries are the same
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof MediaLibrary)) {
      return false;
    }

    MediaLibrary library = (MediaLibrary) object;

    if (getMovies() != null ? !getMovies().equals(library.getMovies())
        : library.getMovies() != null) {
      return false;
    }
    return getTvShows() != null ? getTvShows().equals(library.getTvShows())
        : library.getTvShows() == null;

  }

  /**
   * Generates a hashcode for the library.
   *
   * @return hashcode for the library
   */
  @Override
  public int hashCode() {
    int result = getMovies() != null ? getMovies().hashCode() : 0;
    result = 31 * result + (getTvShows() != null ? getTvShows().hashCode() : 0);
    return result;
  }

  /**
   * Generates a string version of the library/contents.
   *
   * @return string of the contents of the media library
   */
  @Override
  public String toString() {
    return "MediaLibrary{"
        + "movies=" + movies
        + ", tvShows=" + tvShows
        + '}';
  }
}
