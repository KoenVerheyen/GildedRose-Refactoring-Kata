package com.gildedrose.inventory;

import com.gildedrose.Item;
import com.gildedrose.inventory.update.UpdateInventoryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateInventoryTest {
    @Test
    void agedBrie_increaseQuality() {
        String itemName = "Aged Brie";
        Item[] items = createInventoryItem(itemName, 10, 10);
        updateInventory(items);
        assertEquals(itemName, items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }

    @Test
    void agedBrie_At50StopIncreasing() {
        String itemName = "Aged Brie";
        Item[] items = createInventoryItem(itemName, 10, 49);
        updateInventory(items);
        assertEquals(itemName, items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
        updateInventory(items);
        assertEquals(itemName, items[0].name);
        assertEquals(8, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void agedBrieSellInNegative_IncreaseQualityBy2() {
        String itemName = "Aged Brie";
        Item[] items = createInventoryItem(itemName, 0, 20);
        updateInventory(items);
        assertEquals(itemName, items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(22, items[0].quality);
        updateInventory(items);
        assertEquals(itemName, items[0].name);
        assertEquals(-2, items[0].sellIn);
        assertEquals(24, items[0].quality);
    }

    @Test
    void Sulfuras_neverChanges() {
        Item[] items = createInventoryItem("Sulfuras, Hand of Ragnaros", 20, 80);

        updateInventory(items);
        assertEquals(20, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void BackStagePasses_increaseInQuality() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 20, 5);
        updateInventory(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void BackStagePassesOn11thDay_increaseInQuality() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 11, 5);
        updateInventory(items);

        assertEquals(10, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void BackStagePassesLast10Days_increaseInQualityBy2() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 10, 5);
        updateInventory(items);

        assertEquals(9, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void BackStagePassesLast6thDay_increaseInQualityBy2() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 6, 5);
        updateInventory(items);

        assertEquals(5, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void BackStagePassesLast5Days_increaseInQualityBy3() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        updateInventory(items);

        assertEquals(4, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void BackStagePassesLastDay_increaseInQualityBy3() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 1, 5);
        updateInventory(items);

        assertEquals(0, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void BackStagePassesAt50Quality_NoMoreIncrease() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 20, 50);
        updateInventory(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void BackStagePassesAt49QualityLast10Days_IncreaseUntil50() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        updateInventory(items);

        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void BackStagePassesAt49QualityLast5Days_IncreaseUntil50() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        updateInventory(items);

        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void BackStagePassesConcertPassed_qualityIs0() {
        Item[] items = createInventoryItem("Backstage passes to a TAFKAL80ETC concert", 0, 5);
        updateInventory(items);

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void normal_DegenerationOfQuality() {
        Item[] items = createInventoryItem("foobar", 20, 50);
        updateInventory(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(49, items[0].quality);
    }

    @Test
    void normalDueIn1Day_NormalDegenerationOfQuality() {
        Item[] items = createInventoryItem("foobar", 1, 20);
        updateInventory(items);

        assertEquals(0, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void normalExpired_FasterDegenerationOfQuality() {
        Item[] items = createInventoryItem("foobar", 0, 20);
        updateInventory(items);

        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void normalBut0Quality_NoMoreQualityChange() {
        Item[] items = createInventoryItem("foobar", 20, 0);
        updateInventory(items);

        assertEquals(19, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void normalExpiredAnd1Quality_QualityDropsTo0() {
        Item[] items = createInventoryItem("foobar", -5, 1);
        updateInventory(items);

        assertEquals(-6, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void conjuredItem_sellInDecreaseAsNormal() {
        Item[] items = createInventoryItem("Conjured Mana cakes", 20, 40);
        updateInventory(items);

        assertEquals(19, items[0].sellIn);
    }

    @Test
    void conjuredItemBeforeSellIn_qualityDecreaseTwiceAsNormal() {
        Item[] items = createInventoryItem("Conjured Mana cakes", 20, 40);
        updateInventory(items);
        assertEquals(38, items[0].quality);
    }

    @Test
    void conjuredItemAfterSellIn_qualityDecreaseTwiceAsNormal() {
        Item[] items = createInventoryItem("Conjured Mana cakes", 0, 40);
        updateInventory(items);
        assertEquals(36, items[0].quality);
    }

    @Test
    void conjuredItem_qualityDecreaseUntil0() {
        Item[] items = createInventoryItem("Conjured Mana cakes", 20, 1);
        updateInventory(items);
        assertEquals(0, items[0].quality);
    }

    @Test
    void conjuredItemExpired_qualityDecreaseUntil0() {
        Item[] items = createInventoryItem("Conjured Mana cakes", -2, 3);
        updateInventory(items);
        assertEquals(0, items[0].quality);
    }

    @Test
    void ItemWithNoName_NormalBehaviour() {
        Item[] items = createInventoryItem(null, 5, 3);
        updateInventory(items);
        assertEquals(4, items[0].sellIn);
        assertEquals(2, items[0].quality);
    }

    private void updateInventory(Item[] items) {
        UpdateInventoryService service = new UpdateInventoryService(items);
        service.updateInventory();
    }

    private Item[] createInventoryItem(String itemName, int sellIn, int quality) {
        return new Item[] { new Item(itemName, sellIn, quality)};
    }
}
