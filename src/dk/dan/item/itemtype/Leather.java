package dk.dan.item.itemtype;

import dk.dan.Stats;
import dk.dan.item.ItemSlot;

public class Leather implements ItemType {

    /**
     * Instantiable class for Leather items.
     * See docs on ItemType for clarification.
     */

    private final Stats BASE_STATS = new Stats(20, 1, 3, 0, 0);
    private final Stats STATS_ON_LEVEL = new Stats(8, 1, 2, 0, 0);

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
