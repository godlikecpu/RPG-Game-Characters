package dk.dan.hero;

import dk.dan.Stats;

public class Ranger implements HeroClass {
    private final String NAME = "Ranger";
    private final Stats BASE_STATS = new Stats(120, 5, 10, 2, 0);
    private final Stats STATS_ON_LEVEL = new Stats(20, 2, 5, 1, 0);

    @Override
    public void calculateBonusStats() {

    }


    @Override
    public Stats getStatsOnLevel() {
        return this.STATS_ON_LEVEL;
    }

    @Override
    public Stats getBaseStats() {
        return this.BASE_STATS;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}
