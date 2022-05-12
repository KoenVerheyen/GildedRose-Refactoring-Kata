package com.gildedrose.inventory;

import com.gildedrose.Item;

public class InventoryItem {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    private final Item item;


    public InventoryItem(Item item) {
        this.item = item;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void reduceSellIn() {
        item.sellIn -= 1;
    }

    public boolean isMaxQuality() {
        return item.quality >= MAX_QUALITY;
    }

    public boolean isMinQuality() {
        return item.quality <= 0;
    }

    public void increaseQualityBy(int amount) {
        item.quality += amount;
    }

    public void reduceQualityBy(int amount) {
        item.quality -= amount;
    }

    public boolean isItemExpired() {
        return item.sellIn < 0;
    }

    public void resetQualityToMaximum() {
        item.quality = MAX_QUALITY;
    }

    public void resetQualityToMinimum() {
        item.quality = MIN_QUALITY;
    }
}
