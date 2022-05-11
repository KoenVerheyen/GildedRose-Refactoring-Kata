package com.gildedrose;

public class DefaultQualityModifier implements QualityModifier {
    private final Item item;

    DefaultQualityModifier(Item item) {
        this.item = item;
    }


    @Override
    public void adjustQuality() {
        deductQualityBeforeSellIn(item);
        reduceSellIn(item);
        deductQualityAfterSellIn(item);
    }

    private void reduceSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void deductQualityBeforeSellIn(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void deductQualityAfterSellIn(Item item) {
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
