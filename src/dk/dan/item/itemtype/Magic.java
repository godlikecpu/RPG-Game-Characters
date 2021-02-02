package dk.dan.item.itemtype;

import dk.dan.Stats;
import dk.dan.item.ItemSlot;

public class Magic implements ItemType {

    /**
     * Instantiable class for Magic weapon items.
     * See docs on ItemType for clarification.
     */

    private final Stats BASE_STATS = new Stats(0, 0, 0, 0, 25);
    private final Stats STATS_ON_LEVEL = new Stats(0, 0, 0, 0, 2);

    @Override
    public Stats getScaledStats(Stats heroStats, Stats itemStats, ItemSlot itemSlot) {
        int damage = (int) Math.floor(itemStats.getDamage() + (heroStats.getIntelligence() * 3));
        itemStats.setDamage(damage);
        return itemStats;
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
