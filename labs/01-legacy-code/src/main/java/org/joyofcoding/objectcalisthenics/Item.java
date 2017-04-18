package org.joyofcoding.objectcalisthenics;

public class Item {
    private String name;
    private int sellIn;
    private int quality;
    private Strategiser strategy;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
        this.strategy = new ElseReplacement();

    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void sellOneNotSulfurasItem() {
        if(!name.equals("Sulfuras, Hand of Ragnaros")) {
            this.sellIn = sellIn - 1;
        }
    }

    public int getQuality() {
        return quality;
    }

    public void addOneToQuality() {
        if (quality < 50) {
            this.quality++;
        }
    }

    public void minOneFromQuality() {
        if (quality > 0) {
            this.quality--;
        }
    }

    public void nullQuality()
    {
        this.quality = 0;
    }

    public void adjustQualityOfNonBrieOrConcertItem() {

        if (!name.equals("Aged Brie") && !name.equals("Backstage passes to a TAFKAL80ETC concert"))
        {
            strategy = new IfReplacement();
        }

        strategy.adjustQuality(this);
    }

    public void updateQualityOfLowInventoryItems() {
        if (getSellIn() < 0)
            applyNonBrieQualityRule();
    }

    private void applyNonBrieQualityRule() {
        strategy = new ElseReplacement();

        if (!getName().equals("Aged Brie"))
            strategy = new IfReplacement();

        strategy.applyQualityRule(this);
    }

    public void applyDegradeNonPassRule() {
        strategy = new ElseReplacement();

        if (!getName().equals("Backstage passes to a TAFKAL80ETC concert"))
            strategy = new IfReplacement();

        strategy.applyDegradeRule(this);

    }

    public void degradeOneNotSulfurasItem() {
        if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
            minOneFromQuality();
        }
    }

    public void improveBackstagePassQuality() {
        if (getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            improveQualityOfMediumStockItem();
            improveQualityOfLowStockItem();
        }
    }
    public void improveQualityOfLowStockItem() {
        if (getSellIn() < 6) {
            addOneToQuality();
        }
    }

    public void improveQualityOfMediumStockItem() {
        if (getSellIn() < 11) {
            addOneToQuality();
        }
    }



}
