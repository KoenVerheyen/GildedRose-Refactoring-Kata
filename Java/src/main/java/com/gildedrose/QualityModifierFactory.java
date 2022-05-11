package com.gildedrose;

public class QualityModifierFactory {
    public static QualityModifier create(Item item) {
        if ("Aged Brie".equals(item.name)) {
            return new AgedBrieQualityModifier(item);
        }
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new LegendaryItemQualityModifier(item);
        }
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            return new BackStagePassesQualityModifier(item);
        }
        return new DefaultQualityModifier(item);
    }
}
