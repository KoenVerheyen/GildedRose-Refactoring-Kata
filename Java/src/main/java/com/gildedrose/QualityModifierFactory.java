package com.gildedrose;

public class QualityModifierFactory {
    public static QualityModifier create(Item item) {
        if ("Aged Brie".equals(item.name)) {
            return new AgedBrieQualityModifier(item);
        }
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new LegendaryItemQualityModifier(item);
        }
        return new DefaultQualityModifier(item);
    }
}
