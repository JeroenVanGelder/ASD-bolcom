package org.joyofcoding.objectcalisthenics;


public interface Strategiser {
    void adjustQuality(Item strategizedItem);
    void applyQualityRule(Item strategizedItem);
    void applyDegradeRule(Item strategizedItem);

}

class IfReplacement implements Strategiser{

    public void adjustQuality(Item strategizedItem) {
        strategizedItem.degradeOneNotSulfurasItem();
    }

    public void applyQualityRule(Item strategizedItem) {
        strategizedItem.applyDegradeNonPassRule();
    }

    public void applyDegradeRule(Item strategizedItem) {
        strategizedItem.degradeOneNotSulfurasItem();
    }
}

class ElseReplacement implements Strategiser{

    public void adjustQuality(Item strategizedItem) {
        strategizedItem.addOneToQuality();
        strategizedItem.improveBackstagePassQuality();
    }

    public void applyQualityRule(Item strategizedItem) {
        strategizedItem.addOneToQuality();
    }

    public void applyDegradeRule(Item strategizedItem) {
        strategizedItem.nullQuality();
    }
}
