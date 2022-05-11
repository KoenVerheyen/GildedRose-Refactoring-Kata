package com.gildedrose;

public class DefaultQualityModifier implements QualityModifier {
    private final Item item;

    DefaultQualityModifier(Item item) {
        this.item = item;
    }


    @Override
    public void adjustQuality() {
        reduceSellIn();
        if (isBottomQuality()) {
            return;
        }
        reduceQuality();
        if (isBottomQuality()) {
            item.quality = 0;
            return;
        }
    }

    private void reduceQuality() {
        if (isItemExpired()) {
            doubleQualityReduction();
            return;
        }
        qualityReduction();
    }

    private boolean isBottomQuality() {
        return item.quality <= 0;
    }

    private void qualityReduction() {
        item.quality -= 1;
    }

    private void doubleQualityReduction() {
        item.quality -= 2;
    }

    private boolean isItemExpired() {
        return item.sellIn < 0;
    }

    private void reduceSellIn() {
        item.sellIn = item.sellIn - 1;
    }

}
