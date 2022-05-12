package com.gildedrose.inventory.update;

import com.gildedrose.Item;
import com.gildedrose.inventory.InventoryItem;

public class UpdateInventoryItemFactory {
    public static UpdateInventoryItem create(Item item) {
        if ("Aged Brie".equals(item.name)) {
            return new UpdateInventoryItemAgedBrie(new InventoryItem(item));
        }
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new UpdateInventoryItemLegendaryItem(new InventoryItem(item));
        }
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            return new UpdateInventoryItemBackStagePasses(new InventoryItem(item));
        }
        return new UpdateInventoryItemNormal(new InventoryItem(item));
    }
}
