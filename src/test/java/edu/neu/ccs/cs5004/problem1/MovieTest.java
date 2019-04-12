package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem2.Name;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {
  private List<Director> directors = new ArrayList<>();
  private List<Actor> actors = new ArrayList<>();
  private Name name1 = new Name("Adam", "McKay");
  private Director director1 = new Director(name1);
  private Actor actor1 = new Actor(new Name("Don", "Cheadle"));
  private Movie testMovie = new Movie("The2010", "The Avengers", 2010, directors, actors);
  private Movie testMovie2 = new Movie("The2010", "The Avengers", 2010, directors, actors);
  private Movie testMovie3 = new Movie("The30", "Amazing!", 2040, directors, actors);
  private Movie testMovie4 = new Movie("The2010", "The Avengers", 2050, directors, actors);
  private Movie testMovie5 = new Movie("The2010", "Blah", 2040, directors, actors);
  private Movie testMovie6 = new Movie("The2010", "Blah", 2040, null, actors);
  private Movie testMovie7 = new Movie("The2010", "Blah", 2040, directors, null);

  @Before
  public void setUp() {
    this.directors.add(this.director1);
    this.actors.add(this.actor1);
  }

  @Test(expected = InvalidYearException.class)
  public void testWrongYear() {
    Movie newMovie = new Movie("blah", "blah", 9, this.directors, this.actors);
  }

  @Test
  public void getTitle() {
    Assert.assertEquals("The Avengers", this.testMovie.getTitle());
  }

  @Test
  public void getReleaseYear() {
    Assert.assertEquals(2010, this.testMovie.getReleaseYear(), 0);
  }

  @Test
  public void getDirectors() {
    Assert.assertEquals(this.directors, this.testMovie.getDirectors());
  }

  @Test
  public void getActors() {
    Assert.assertEquals(this.actors, this.testMovie.getActors());
  }

  @Test
  public void getAlias() {
    Assert.assertEquals("The2010", this.testMovie.getAlias());
  }

  @Test
  public void testInitialStreamCount() {
    Assert.assertEquals(0, this.testMovie.getStreamCount(), 0);
  }

  @Test
  public void addToStreamCount() {
    this.testMovie.addToStreamCount();
    Assert.assertEquals(1, this.testMovie.getStreamCount(), 0);
  }

  @Test(expected = NullPointerException.class)
  public void testEquals() {
    Name testName = new Name("blah", "blah");

    Assert.assertEquals(this.testMovie, testMovie2);
    Assert.assertNotEquals(this.testMovie3, this.testMovie);
    Assert.assertNotEquals(this.testMovie4, this.testMovie);
    Assert.assertNotEquals(this.testMovie5, this.testMovie);
    Assert.assertNotEquals(this.testMovie6, this.testMovie5);
    Assert.assertNotEquals(this.testMovie7, this.testMovie5);
    Assert.assertNotEquals(this.testMovie7, testName);
  }

  @Test
  public void testToString() {
    Assert.assertEquals(this.testMovie2.toString(), this.testMovie.toString());
  }
}