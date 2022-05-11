package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        items = Arrays.stream(items).map(this::updateQualityForItem).toArray(Item[]::new);
    }

    private Item updateQualityForItem(Item item) {
        QualityModifier qualityModifier = QualityModifierFactory.create(item);
        return qualityModifier.adjustQuality();
    }


}
