package dk.dan.item;

import dk.dan.Stats;

public interface ItemType {

    public Stats getScaledStats(Stats heroStats, Stats itemStats);

    public Stats getStatsOnLevel();

    public Stats getBaseStats();
}
