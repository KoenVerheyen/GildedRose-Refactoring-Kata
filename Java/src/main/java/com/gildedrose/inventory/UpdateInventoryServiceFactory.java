package com.gildedrose.inventory;

import com.gildedrose.Item;
import com.gildedrose.inventory.item.UpdateInventoryItemFactoryImpl;

public class UpdateInventoryServiceFactory {

    public static UpdateInventoryService create(Item[] items) {
        return new UpdateInventoryServiceImpl(items, new UpdateInventoryItemFactoryImpl());
    }
}
