package com.gildedrose.inventory.item;

public interface InventoryItem {
    String getName();

    int getSellIn();

    void reduceSellIn();

    boolean isMaxQuality();

    boolean isMinQuality();

    void increaseQualityBy(int amount);

    void reduceQualityBy(int amount);

    boolean isItemExpired();

    void resetQualityToMaximum();

    void resetQualityToMinimum();

    boolean isNull();
}
