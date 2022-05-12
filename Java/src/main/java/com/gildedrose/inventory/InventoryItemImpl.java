package com.gildedrose.inventory;

import com.gildedrose.Item;
import com.gildedrose.inventory.item.InventoryItem;

public class InventoryItemImpl implements InventoryItem {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private final Item item;


    public InventoryItemImpl(Item item) {
        this.item = item;
    }

    @Override
    public String getName() {
        return item.name;
    }

    @Override
    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public void reduceSellIn() {
        item.sellIn -= 1;
    }

    @Override
    public boolean isMaxQuality() {
        return item.quality >= MAX_QUALITY;
    }

    @Override
    public boolean isMinQuality() {
        return item.quality <= MIN_QUALITY;
    }

    @Override
    public void increaseQualityBy(int amount) {
        item.quality += amount;
    }

    @Override
    public void reduceQualityBy(int amount) {
        item.quality -= amount;
    }

    @Override
    public boolean isItemExpired() {
        return item.sellIn < 0;
    }

    @Override
    public void resetQualityToMaximum() {
        item.quality = MAX_QUALITY;
    }

    @Override
    public void resetQualityToMinimum() {
        item.quality = MIN_QUALITY;
    }

    @Override
    public boolean isNull() {
        return item == null;
    }
}
