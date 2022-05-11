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
        updateQuality(items);
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
        updateQuality(items);
        assertEquals(itemName, items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(22, items[0].quality);
        updateQuality(items);
        assertEquals(itemName, items[0].name);
        assertEquals(-2, items[0].sellIn);
        assertEquals(24, items[0].quality);
    }

    @Test
    void Sulfuras_neverChanges() {
        Item[] items = createItems("Sulfuras, Hand of Ragnaros", 20, 80);

        updateQuality(items);
        assertEquals(20, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void BackStagePasses_increaseInQuality() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 20, 5);
        updateQuality(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void BackStagePassesOn11thDay_increaseInQuality() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 11, 5);
        updateQuality(items);

        assertEquals(10, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void BackStagePassesLast10Days_increaseInQualityBy2() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 10, 5);
        updateQuality(items);

        assertEquals(9, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void BackStagePassesLast6thDay_increaseInQualityBy2() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 6, 5);
        updateQuality(items);

        assertEquals(5, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void BackStagePassesLast5Days_increaseInQualityBy3() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        updateQuality(items);

        assertEquals(4, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void BackStagePassesLastDay_increaseInQualityBy3() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 1, 5);
        updateQuality(items);

        assertEquals(0, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void BackStagePassesAt50Quality_NoMoreIncrease() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 20, 50);
        updateQuality(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void BackStagePassesAt49QualityLast10Days_IncreaseUntil50() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        updateQuality(items);

        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void BackStagePassesAt49QualityLast5Days_IncreaseUntil50() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        updateQuality(items);

        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void BackStagePassesConcertPassed_qualityIs0() {
        Item[] items = createItems("Backstage passes to a TAFKAL80ETC concert", 0, 5);
        updateQuality(items);

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void default_DegenerationOfQuality() {
        Item[] items = createItems("foobar", 20, 50);
        updateQuality(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(49, items[0].quality);
    }

    @Test
    void defaultDueIn1Day_NormalDegenerationOfQuality() {
        Item[] items = createItems("foobar", 1, 20);
        updateQuality(items);

        assertEquals(0, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void defaultExpired_FasterDegenerationOfQuality() {
        Item[] items = createItems("foobar", 0, 20);
        updateQuality(items);

        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void defaultBut0Quality_NoMoreQualityChange() {
        Item[] items = createItems("foobar", 20, 0);
        updateQuality(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void defaultExpiredAnd1Quality_QualityDropsTo0() {
        Item[] items = createItems("foobar", -5, 1);
        updateQuality(items);

        assertEquals(-6, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    private void updateQuality(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }

    private Item[] createItems(String itemName, int sellIn, int quality) {
        return new Item[] { new Item(itemName, sellIn, quality)};
    }


}
