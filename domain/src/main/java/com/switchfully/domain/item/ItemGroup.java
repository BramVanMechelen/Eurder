package com.switchfully.domain.item;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import static com.switchfully.domain.repositiories.ItemAndOrderRepository.*;

public class ItemGroup {
    private String itemName;
    private int amount;
    private LocalDate shippingDate;
    private double price;

    public ItemGroup(String itemName, int amount) {
        this.itemName = itemName;
        this.amount = amount;
        this.shippingDate = LocalDate.now().plus(5, ChronoUnit.YEARS);
        if (getItemsMap().get(itemName) != null) {
            this.price = getItemsMap().get(itemName).getPrice() * amount;
        }
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

    public double getPrice() {
        return price;
    }

    public void removeFromStock(){
        getItemsMap().get(getItemName()).setAmount(getItemsMap().get(getItemName()).getAmount() - getAmount());
    }

    public ItemGroup merge(ItemGroup other) {
        assert (this.equals(other));
        return new ItemGroup(this.itemName, this.amount + other.getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemGroup itemGroup = (ItemGroup) o;
        return Objects.equals(itemName, itemGroup.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }
}
