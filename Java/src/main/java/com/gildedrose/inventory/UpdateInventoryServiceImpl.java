package com.gildedrose.inventory;

import com.gildedrose.Item;

import java.util.Arrays;

public class UpdateInventoryServiceImpl implements UpdateInventoryService {
    private final Item[] items;
    private final UpdateInventoryItemFactory updateInventoryItemFactory;

    UpdateInventoryServiceImpl(Item[] items) {
        this.items = items;
        this.updateInventoryItemFactory = new UpdateInventoryItemFactoryImpl();
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
