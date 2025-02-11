package com.gildedrose.inventory;

import com.gildedrose.Item;
import com.gildedrose.inventory.item.InventoryItem;

import java.util.Arrays;

public class UpdateInventoryServiceImpl implements UpdateInventoryService {
    private final Item[] items;
    private final UpdateInventoryItemFactory updateInventoryItemFactory;

    UpdateInventoryServiceImpl(Item[] items, UpdateInventoryItemFactory updateInventoryServiceFactory) {
        this.items = items;
        this.updateInventoryItemFactory = updateInventoryServiceFactory;
    }

    @Override
    public void updateInventory() {
        Arrays.stream(items).map(InventoryItemImpl::new).forEach(this::updateInventory);
    }

    private void updateInventory(InventoryItem item) {
        UpdateInventoryItem updateInventoryItem = updateInventoryItemFactory.create(item);
        updateInventoryItem.adjustSellByTime();
        updateInventoryItem.adjustQuality();
    }
}
