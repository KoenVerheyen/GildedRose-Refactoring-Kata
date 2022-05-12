package com.gildedrose;

import com.gildedrose.inventory.update.UpdateInventoryService;
import com.gildedrose.inventory.update.UpdateInventoryServiceFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        UpdateInventoryService service = UpdateInventoryServiceFactory.create(items);
        service.updateInventory();
    }

}
