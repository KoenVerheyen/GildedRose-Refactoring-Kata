package com.gildedrose.inventory;

import com.gildedrose.Item;
import com.gildedrose.inventory.item.InventoryItem;
import com.gildedrose.inventory.item.UpdateInventoryItem;
import com.gildedrose.inventory.item.UpdateInventoryItemFactory;

import java.util.Arrays;

public class UpdateInventoryServiceImpl implements UpdateInventoryService {
    private final Item[] items;

    UpdateInventoryServiceImpl(Item[] items) {
        this.items = items;
    }

    @Override
    public void updateInventory() {
        Arrays.stream(items).map(InventoryItemImpl::new).forEach(this::updateInventory);
    }

    private void updateInventory(InventoryItem item) {
        UpdateInventoryItem updateInventoryItem = UpdateInventoryItemFactory.create(item);
        updateInventoryItem.adjustSellByTime();
        updateInventoryItem.adjustQuality();
    }
}
