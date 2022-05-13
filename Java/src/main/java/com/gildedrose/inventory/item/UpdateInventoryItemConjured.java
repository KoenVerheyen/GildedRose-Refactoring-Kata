package com.gildedrose.inventory.item;

public class UpdateInventoryItemConjured implements UpdateInventoryItem {
    private final UpdateInventoryItemNormal updateInventoryItemNormal;

    public UpdateInventoryItemConjured(InventoryItem item) {
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
