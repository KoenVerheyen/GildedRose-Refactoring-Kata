package com.gildedrose;

public class AgedBrieQualityModifier implements QualityModifier{
    private final Item item;

    public AgedBrieQualityModifier(Item item) {
        this.item = item;
    }

    @Override
    public void adjustQuality() {
        item.sellIn = item.sellIn -1;
        if (isMaxQuality()) {
            return;
        }
        if (isItemExpired()) {
            increaseQualityBy2();
        } else {
            increaseQualityBy1();
        }
    }

    private boolean isMaxQuality() {
        return item.quality >= 50;
    }

    private void increaseQualityBy1() {
        item.quality = item.quality+1;
    }

    private void increaseQualityBy2() {
        item.quality = item.quality +2;
    }

    private boolean isItemExpired() {
        return item.sellIn < 0;
    }
}
