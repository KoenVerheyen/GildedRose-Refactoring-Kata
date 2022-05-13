package com.gildedrose.inventory.item;

import com.gildedrose.inventory.UpdateInventoryItem;

public class UpdateInventoryItemAgedBrie implements UpdateInventoryItem {
    private final InventoryItem item;

    UpdateInventoryItemAgedBrie(InventoryItem item) {
        this.item = item;
    }

    @Override
    public void adjustQuality() {
        if (item.isMaxQuality()) {
            return;
        }
        if (item.isItemExpired()) {
            item.increaseQualityBy(2);
        } else {
            item.increaseQualityBy(1);
        }
    }

    @Override
    public void adjustSellByTime() {
        item.reduceSellIn();
    }

}
