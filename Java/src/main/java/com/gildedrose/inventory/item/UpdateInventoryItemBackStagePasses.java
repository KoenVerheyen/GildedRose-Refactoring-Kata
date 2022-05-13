package com.gildedrose.inventory.item;

public class UpdateInventoryItemBackStagePasses implements UpdateInventoryItem {
    private final InventoryItem item;

    public UpdateInventoryItemBackStagePasses(InventoryItem item) {
        this.item = item;
    }


    @Override
    public void adjustQuality() {
        if (item.isItemExpired()) {
            item.resetQualityToMinimum();
            return;
        }

        if (item.isMaxQuality()) {
            return;
        }
        doQualityIncrease();

        if (item.isMaxQuality()) {
            item.resetQualityToMaximum();
            return;
        }
    }

    @Override
    public void adjustSellByTime() {
        item.reduceSellIn();
    }

    private void doQualityIncrease() {
        if (isConcertWithin5Days()) {
            item.increaseQualityBy(3);
            return;
        }
        if (isConcertWithin10days()) {
            item.increaseQualityBy(2);
            return;
        }
        item.increaseQualityBy(1);
    }

    private boolean isConcertWithin5Days() {
        return item.getSellIn() < 5;
    }

    private boolean isConcertWithin10days() {
        return item.getSellIn() < 10;
    }

}
