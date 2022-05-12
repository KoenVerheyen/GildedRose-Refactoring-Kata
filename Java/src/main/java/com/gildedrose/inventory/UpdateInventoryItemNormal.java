package com.gildedrose.inventory;

public class UpdateInventoryItemNormal implements UpdateInventoryItem {
    private final InventoryItem item;

    UpdateInventoryItemNormal(InventoryItem item) {
        this.item = item;
    }

    @Override
    public void adjustQuality() {
        if (item.isMinQuality()) {
            return;
        }
        reduceQuality();
        if (item.isMinQuality()) {
            item.resetQualityToMinimum();
            return;
        }
    }

    @Override
    public void adjustSellByTime() {
        item.reduceSellIn();
    }

    private void reduceQuality() {
        if (item.isItemExpired()) {
            item.reduceQualityBy(2);
            return;
        }
        item.reduceQualityBy(1);
    }


}
