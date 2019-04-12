package edu.neu.ccs.cs5004.problem1;


import edu.neu.ccs.cs5004.problem2.Name;
import org.junit.Assert;
import org.junit.Test;

public class ActorTest {
  private Actor testActor = new Actor(new Name("Bradley", "Cooper"));

  @Test
  public void getName() {
    Assert.assertEquals("Bradley", this.testActor.getName().getFirst());
    Assert.assertEquals("Cooper", this.testActor.getName().getLast());
  }

  @Test
  public void testEquals() {
    Actor testActor2 = new Actor(new Name("Bradley", "Cooper"));
    Assert.assertEquals(this.testActor, testActor2);
    Assert.assertEquals(this.testActor, this.testActor);
    Actor testActor3 = null;
    Assert.assertNotEquals(testActor3, this.testActor);
  }

  @Test
  public void testActorString() {
    Assert.assertEquals("Actor: Bradley Cooper", this.testActor.toString());
  }
}