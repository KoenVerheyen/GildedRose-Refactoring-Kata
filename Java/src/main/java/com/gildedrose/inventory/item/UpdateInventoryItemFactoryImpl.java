package com.gildedrose.inventory.item;

import com.gildedrose.inventory.UpdateInventoryItem;
import com.gildedrose.inventory.UpdateInventoryItemFactory;

public class UpdateInventoryItemFactoryImpl implements UpdateInventoryItemFactory {
    @Override
    public UpdateInventoryItem create(InventoryItem item) {
        if (item == null || item.isNull()) {
            return new UpdateInventoryItemNull();
        }
        if ("Aged Brie".equals(item.getName())) {
            return new UpdateInventoryItemAgedBrie(item);
        }
        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            return new UpdateInventoryItemLegendaryItem(item);
        }
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            return new UpdateInventoryItemBackStagePasses(item);
        }
        if (item.getName() != null && item.getName().startsWith("Conjured")) {
            return new UpdateInventoryItemConjured(item);
        }
        return new UpdateInventoryItemNormal(item);
    }
}
