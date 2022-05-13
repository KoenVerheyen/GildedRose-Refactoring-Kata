package com.gildedrose.inventory.item;

import com.gildedrose.inventory.UpdateInventoryItem;

public class UpdateInventoryItemLegendaryItem implements UpdateInventoryItem {
    private final InventoryItem item;

    UpdateInventoryItemLegendaryItem(InventoryItem item) {
        this.item = item;
    }


    @Override
    public void adjustQuality() {
        // Legendary items never have to be sold nor has a quality change
    }

    @Override
    public void adjustSellByTime() {
        // Legendary items don't expire
    }
}
