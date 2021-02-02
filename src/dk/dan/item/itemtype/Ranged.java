package dk.dan.item.itemtype;

import dk.dan.Stats;
import dk.dan.item.ItemSlot;

public class Ranged implements ItemType {
    
    /**
     * Instantiable class for Ranged weapon items.
     * See docs on ItemType for clarification.
     */

    private final Stats BASE_STATS = new Stats(0, 0, 0, 0, 5);
    private final Stats STATS_ON_LEVEL = new Stats(0, 0, 0, 0, 3);

    @Override
    public Stats getScaledStats(Stats heroStats, Stats itemStats, ItemSlot itemSlot) {
        int damage = (int) Math.floor(itemStats.getDamage() + (heroStats.getDexterity() * 2));
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
