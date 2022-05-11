package com.gildedrose;

public class QualityModifierFactory {
    public static QualityModifier create(Item item) {
        return new DefaultQualityModifier(item);
    }
}
