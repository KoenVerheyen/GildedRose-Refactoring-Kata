package com.gildedrose;

public class BackStagePassesQualityModifier implements QualityModifier{
    private final Item item;

    public BackStagePassesQualityModifier(Item item) {
        this.item = item;
    }


    @Override
    public void adjustQuality() {
        item.sellIn = item.sellIn -1;
        if (isConcertPassed()) {
            clearQuality();
            return;
        }

        if (isMaxQuality()) {
            return;
        }
        doQualityIncrease();

        if (isMaxQuality()) {
            item.quality = 50;
            return;
        }
    }

    private void doQualityIncrease() {
        if (isConcertWithin5Days()) {
            finalDaysQualityIncrease();
            return;
        }
        if (isConcertWithin10days()) {
            qualityDoubleIncrease();
            return;
        }
        qualityIncrease();
    }

    private boolean isMaxQuality() {
        return item.quality >= 50;
    }

    private void qualityIncrease() {
        item.quality += 1;
    }
    private void qualityDoubleIncrease() {
        item.quality += 2;
    }
    private void finalDaysQualityIncrease() {
        item.quality += 3;
    }
    private void clearQuality() {
        item.quality = 0;
    }

    private boolean isConcertWithin10days() {
        return item.sellIn < 10;
    }

    private boolean isConcertWithin5Days() {
        return item.sellIn < 5;
    }

    private boolean isConcertPassed() {
        return item.sellIn < 0;
    }
}
