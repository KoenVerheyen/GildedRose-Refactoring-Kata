package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateQualityForItem);
    }

    private void updateQualityForItem(Item item) {
        QualityModifier qualityModifier = QualityModifierFactory.create(item);
        qualityModifier.adjustQuality();
    }


}
