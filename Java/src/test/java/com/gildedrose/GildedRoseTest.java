package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void agedBrie_increaseQuality() {
        String itemName = "Aged Brie";
        Item[] items = createItems(itemName, 10, 10);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(itemName, items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }

    @Test
    void agedBrie_At50StopIncreasing() {
        String itemName = "Aged Brie";
        Item[] items = createItems(itemName, 10, 49);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(itemName, items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
        app.updateQuality();
        assertEquals(itemName, items[0].name);
        assertEquals(8, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void agedBrieSellInNegative_IncreaseQualityBy2() {
        String itemName = "Aged Brie";
        Item[] items = createItems(itemName, 0, 20);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(itemName, items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(22, items[0].quality);
        app.updateQuality();
        assertEquals(itemName, items[0].name);
        assertEquals(-2, items[0].sellIn);
        assertEquals(24, items[0].quality);
    }

    private Item[] createItems(String itemName, int sellIn, int quality) {
        return new Item[] { new Item(itemName, sellIn, quality)};
    }


}
