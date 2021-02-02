package dk.dan.item;

import dk.dan.Stats;

public class Cloth implements ItemType {
    private final Stats BASE_STATS = new Stats(10, 0, 1, 3, 0);
    private final Stats STATS_ON_LEVEL = new Stats(5, 0, 1, 2, 0);

    @Override
    public Stats getScaledStats(Stats heroStats, Stats itemStats) {
        heroStats = heroStats.addStats(itemStats);
        return heroStats;
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
