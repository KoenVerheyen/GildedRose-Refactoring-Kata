package com.gildedrose.inventory.item;

import com.gildedrose.inventory.UpdateInventoryItem;

public class UpdateInventoryItemNull implements UpdateInventoryItem {

    UpdateInventoryItemNull() {
        // Hide default constructor
    }

    @Override
    public void adjustQuality() {
        // No item to work on
    }

    @Override
    public void adjustSellByTime() {
        // No item to work on
    }
}
