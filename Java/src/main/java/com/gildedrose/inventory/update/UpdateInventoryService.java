package com.gildedrose.inventory.update;

import com.gildedrose.Item;
import com.gildedrose.inventory.InventoryItem;

import java.util.Arrays;

public class UpdateInventoryService {
    private final Item[] items;

    public UpdateInventoryService(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        Arrays.stream(items).map(InventoryItem::new).forEach(this::updateInventory);
    }

    private void updateInventory(InventoryItem item) {
        UpdateInventoryItem updateInventoryItem = UpdateInventoryItemFactory.create(item);
        updateInventoryItem.adjustSellByTime();
        updateInventoryItem.adjustQuality();
    }
}
