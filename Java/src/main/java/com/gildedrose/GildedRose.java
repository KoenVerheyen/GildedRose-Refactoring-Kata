package com.gildedrose;

import com.gildedrose.inventory.update.UpdateInventoryService;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        UpdateInventoryService service = new UpdateInventoryService(items);
        service.updateInventory();
    }

}
