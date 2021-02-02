package dk.dan.item.itemtype;

import dk.dan.Stats;
import dk.dan.item.ItemSlot;

public class Plate implements ItemType {

    /**
     * Instantiable class for Plate items.
     * See docs on ItemType for clarification.
     */

    private final Stats BASE_STATS = new Stats(30, 3, 1, 0, 0);
    private final Stats STATS_ON_LEVEL = new Stats(12, 2, 1, 0, 0);

    @Override
    public Stats getScaledStats(Stats heroStats, Stats itemStats, ItemSlot itemSlot) {
        return itemStats.scaleStats(itemSlot.scaling());
    }

    @Override
    public Stats getStatsOnLevel() {
        return this.STATS_ON_LEVEL;
    }

    @Override
    public Stats getBaseStats() {
        return this.BASE_STATS;
    }
}
