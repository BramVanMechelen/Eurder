package com.switchfully.domain.item;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ItemGroup {
    private String itemName;
    private int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemName, int amount) {
        this.itemName = itemName;
        this.amount = amount;
  //      if (amountInStock < amount) {
  //          this.shippingDate = LocalDate.now().plus(1, ChronoUnit.DAYS);
  //      }
    }
}
