package com.gildedrose.inventory.update;

import com.gildedrose.Item;

import java.util.Arrays;

public class UpdateInventoryService {
    private final Item[] items;

    public UpdateInventoryService(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        Arrays.stream(items).forEach(this::updateInventory);
    }

    private void updateInventory(Item item) {
        UpdateInventoryItem updateInventoryItem = UpdateInventoryItemFactory.create(item);
        updateInventoryItem.adjustSellByTime();
        updateInventoryItem.adjustQuality();
    }
}
