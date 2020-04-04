package com.switchfully.domain.item;

import com.switchfully.domain.repositiories.ItemAndOrderRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ItemGroup {
    private String itemName;
    private int amount;
    private LocalDate shippingDate;
    private double price;

    public ItemGroup(String itemName, int amount) {
        this.itemName = itemName;
        this.amount = amount;
        this.shippingDate = LocalDate.now().plus(5, ChronoUnit.YEARS);
        this.price = ItemAndOrderRepository.getItemMap().get(itemName).getPrice() * amount;
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

    public ItemGroup merge(ItemGroup other){
        assert(this.equals(other));
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
