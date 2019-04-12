package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem2.Name;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TVShowTest {

  private List<Director> directors = new ArrayList<>();
  private List<Actor> actors = new ArrayList<>();
  private Name name = new Name("Adam", "McKay");
  private Director director1 = new Director(this.name);
  private Actor actor1 = new Actor(new Name("Don", "Cheadle"));
  private TvShow testShow = new TvShow("Mas2010", "Masterchef", 2010, directors, actors);

  @Before
  public void setUp() {
    this.directors.add(this.director1);
    this.actors.add(this.actor1);
  }

  @Test
  public void getTitle() {
    Assert.assertEquals("Masterchef", this.testShow.getTitle());
  }

  @Test
  public void getReleaseYear() {
    Assert.assertEquals(2010, this.testShow.getReleaseYear(), 0);
  }

  @Test
  public void getDirectors() {
    Assert.assertEquals(this.directors, this.testShow.getDirectors());
  }

  @Test
  public void getActors() {
    Assert.assertEquals(this.actors, this.testShow.getActors());
  }

  @Test
  public void getAlias() {
    Assert.assertEquals("Mas2010", this.testShow.getAlias());
  }

  @Test
  public void testInitialStreamCount() {
    Assert.assertEquals(0, this.testShow.getStreamCount(), 0);
  }

  @Test
  public void addToStreamCount() {
    this.testShow.addToStreamCount();
    Assert.assertEquals(1, this.testShow.getStreamCount(), 0);
  }

}