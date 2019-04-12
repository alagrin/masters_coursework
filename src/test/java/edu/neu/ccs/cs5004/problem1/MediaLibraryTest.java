package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem2.Name;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MediaLibraryTest {

  private List<Movie> movies;
  private List<TvShow> tvShows;
  private MediaLibrary testLibrary;
  private List<Director> directors;
  private List<Actor> actors;
  private Director director1;
  private Director director2;
  private Actor actor1;
  private Movie movie1;
  private Movie movie2;
  private TvShow tvShow1;
  private List<Movie> movieList;

  @Before
  
  public void setUp() {
     movies = new ArrayList<>();
     tvShows = new ArrayList<>();
     actors = new ArrayList<>();
     Name name1 = new Name("Martin", "Scorcese");
     Name name2 = new Name("John", "Smith");
     director1 = new Director(name1);
     director2 = new Director(name2);
     directors = new ArrayList<>();
     directors.add(director1);
     actor1 = new Actor(new Name("Brad", "Pitt"));
     movie1 = new Movie("Str1970", "Street Fighter", 1970, directors, actors);

     movie2 = new Movie("So2010", "Something", 2010, directors, actors);
     tvShow1 = new TvShow("Mas2010", "Master Chef", 2010, directors, actors);

     movieList = new ArrayList<>();
    movies.add(movie2);
    movies.add(movie1);
    tvShows.add(tvShow1);
    actors.add(actor1);
    testLibrary = new MediaLibrary(movies, tvShows);
    testLibrary.addNewMedia(movie1, actors, directors);
    testLibrary.addNewMedia(movie2, actors, directors);
    testLibrary.addNewMedia(tvShow1, actors, directors);
  }

  @Test
  public void getAllMediaByDirector() {
    movieList.add(movie1);
    movieList.add(movie2);

    Assert.assertEquals(movieList, testLibrary.getAllMediaByDirector(director1));
  }


  @Test(expected = MediaAlreadyExistsException.class)
  public void addNewMedia() {
    testLibrary.addNewMedia(movie1, actors, directors);
    testLibrary.addNewMedia(tvShow1, actors, directors);
    Assert.assertNotNull(testLibrary);
    Assert.assertSame(movies.get(0), testLibrary.getMovies().get(0));
  }

  @Test
  public void trackStreamRequests() {
    Assert.assertEquals(0, testLibrary.trackStreamRequests("Str1970"), 0);
  }

  @Test(expected = ItemNotFoundException.class)
  public void findMediaByAlias() throws ItemNotFoundException {
    Assert.assertEquals(movie1, testLibrary.findMediaByAlias("Str1970"));
    testLibrary.findMediaByAlias("something");
  }

  @Test
  public void addToStreamRequests() throws ItemNotFoundException{
    testLibrary.addToStreamRequests("Str1970");
    Assert.assertEquals(1, testLibrary.trackStreamRequests("Str1970"), 0);
    testLibrary.addToStreamRequests("abracadabra");
  }

  @Test
  public void getMostStreamed() {
    testLibrary.addToStreamRequests("Str1970");
    testLibrary.addToStreamRequests("Mas2010");
    testLibrary.addToStreamRequests("Mas2010");
    Assert.assertEquals(testLibrary.getTvShows().get(0), testLibrary.getMostStreamed());
  }

  @Test
  public void getMovies() {
    Collections.sort(movies);
    List<Movie> testMovies = testLibrary.getMovies();
    Collections.sort(testMovies);

    Assert.assertEquals(movies,testMovies);
  }

  @Test
  public void getTvShows() {
    Assert.assertEquals(tvShows, testLibrary.getTvShows());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(testLibrary, testLibrary);
    MediaLibrary test = new MediaLibrary(movies, tvShows);
    Assert.assertNotEquals("Not the same", true, testLibrary.equals(test));
  }

  @Test
  public void testHashCode() {
    MediaLibrary test = new MediaLibrary(movies, tvShows);
    Assert.assertEquals(testLibrary.hashCode(), testLibrary.hashCode());
    Assert.assertNotEquals("Not the same", test.hashCode(), testLibrary.hashCode());
  }
}