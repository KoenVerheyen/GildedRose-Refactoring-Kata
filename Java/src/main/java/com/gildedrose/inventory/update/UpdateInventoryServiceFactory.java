package com.gildedrose.inventory.update;

import com.gildedrose.Item;

public class UpdateInventoryServiceFactory {

    public static UpdateInventoryService create(Item[] items) {
        return new UpdateInventoryServiceImpl(items);
    }
}
