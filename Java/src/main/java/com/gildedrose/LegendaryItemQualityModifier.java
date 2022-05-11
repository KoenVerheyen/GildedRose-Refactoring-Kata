package com.gildedrose;

public class LegendaryItemQualityModifier implements QualityModifier{
    private final Item item;

    public LegendaryItemQualityModifier(Item item) {
        this.item = item;
    }


    @Override
    public void adjustQuality() {
        // Legendary items never have to be sold nor has a quality change
    }
}
