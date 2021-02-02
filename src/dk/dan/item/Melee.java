package dk.dan.item;

import dk.dan.Stats;

public class Melee implements ItemType {
    private final Stats BASE_STATS = new Stats(0, 0, 0, 0, 15);
    private final Stats STATS_ON_LEVEL = new Stats(0, 0, 0, 0, 2);

    @Override
    public Stats getScaledStats(Stats heroStats, Stats itemStats) {
        int damage = (int) Math.floor(itemStats.getDamage() + (heroStats.getStrength() * 1.5));
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
