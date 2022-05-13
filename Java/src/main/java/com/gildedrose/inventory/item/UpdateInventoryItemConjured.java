package com.gildedrose.inventory.item;

import com.gildedrose.inventory.UpdateInventoryItem;

public class UpdateInventoryItemConjured implements UpdateInventoryItem {
    private final UpdateInventoryItemNormal updateInventoryItemNormal;

    UpdateInventoryItemConjured(InventoryItem item) {
        this.updateInventoryItemNormal = new UpdateInventoryItemNormal(item);
    }

    @Override
    public void adjustQuality() {
        updateInventoryItemNormal.adjustQuality();
        updateInventoryItemNormal.adjustQuality();
    }

    @Override
    public void adjustSellByTime() {
        updateInventoryItemNormal.adjustSellByTime();
    }
}
