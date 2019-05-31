package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {

  private Inventory testInventory = new Inventory();
  private OnlineStore testStore = new OnlineStore(testInventory);
  private AbstractProduct cheese = new Cheese("darigold", "cheddar", 3.00, 10.0);
  private AbstractProduct shampoo = new Shampoo("loreal", "scented", 4.00, 12);

  @Test
  public void getTotalCostOfOrder() {;
    List<AbstractProduct> items = new ArrayList<>();
    items.add(cheese);
    items.add(shampoo);
    Receipt testReceipt = new Receipt(items,new ArrayList<AbstractProduct>(),
        new ArrayList<AbstractProduct>());
    Assert.assertEquals(7.00, testReceipt.getTotalCostOfOrder() , 0);  }


}