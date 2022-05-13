package com.gildedrose.inventory;

import com.gildedrose.inventory.item.InventoryItem;
import com.gildedrose.inventory.item.UpdateInventoryItem;

public interface UpdateInventoryItemFactory {
    UpdateInventoryItem create(InventoryItem item);
}
