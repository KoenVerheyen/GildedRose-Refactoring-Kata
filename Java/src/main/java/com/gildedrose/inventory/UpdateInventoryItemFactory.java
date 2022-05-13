package com.gildedrose.inventory;

import com.gildedrose.inventory.item.InventoryItem;

public interface UpdateInventoryItemFactory {
    UpdateInventoryItem create(InventoryItem item);
}
