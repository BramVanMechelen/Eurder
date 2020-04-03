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
        this.shippingDate = LocalDate.now().plus(5, ChronoUnit.YEARS);
    }

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
